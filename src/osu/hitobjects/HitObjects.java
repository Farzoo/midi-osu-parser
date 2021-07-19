package osu.hitobjects;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class HitObjects {

    public static final int THRESHOLD = 80;
    private TreeMap<Integer, ArrayList<HitObject>> hitObjects;

    public HitObjects() {
        this.hitObjects = new TreeMap<>(Integer::compare);
    }

    public boolean putHitObject(int time, HitObject hitObject) {
        if(!isHitObjectExists(hitObject)) {
            if(this.hitObjects.containsKey(time)) {
                this.hitObjects.get(time).add(hitObject);
                return true;
            } else {
                ArrayList<HitObject> newHitObjects = new ArrayList<>();
                newHitObjects.add(hitObject);
                this.hitObjects.put(time, newHitObjects);
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return this.hitObjects.size();
    }

    public boolean isHitObjectExists(HitObject hitObject) {
        ArrayList<Integer> keysToVerify = new ArrayList<>();
        Integer lower = this.hitObjects.lowerKey(hitObject.getTime());
        Integer upper = this.hitObjects.higherKey(hitObject.getTime());
        while (lower != null && hitObject.getTime() - lower <= THRESHOLD) {
            keysToVerify.add(lower);
            lower = this.hitObjects.lowerKey(lower);
        }
        while(upper != null && upper - hitObject.getTime() <= THRESHOLD) {
            keysToVerify.add(lower);
            upper = this.hitObjects.higherKey(upper);
        }
        if(this.hitObjects.containsKey(hitObject.getTime()))
            keysToVerify.add(hitObject.getTime());
        boolean found = false;
        for(int i = 0; i < keysToVerify.size() && !found; i++) {
            ArrayList<HitObject> hitObjs = this.hitObjects.get(keysToVerify.get(i));
            int y = 0;
            while (y < hitObjs.size() && !found) {
                if(hitObjs.get(y).sameCoordinates(hitObject)) found = true;
                y++;
            }
        }
        return found;
    }

    public HashSet<HitSample> getAllHitSample() {
        HashSet<HitSample> hitSamples = new HashSet<>();
        for(ArrayList<HitObject> hitObjects : this.hitObjects.values()) {
            for(HitObject hitObject : hitObjects) {
                hitSamples.add(hitObject.getHitSample());
            }
        }
        return hitSamples;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[HitObjects]\n");
        for(ArrayList<HitObject> hitobjs : this.hitObjects.values()) {
            for(HitObject hitobj : hitobjs) {
                sb.append(hitobj.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
