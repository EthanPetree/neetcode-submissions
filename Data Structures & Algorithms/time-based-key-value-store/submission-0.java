class TimeMap {
    private HashMap<String, List<String[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new String[]{value, String.valueOf(timestamp)});
        } else {
            List<String[]> temp = new ArrayList<>();
            temp.add(new String[]{value, String.valueOf(timestamp)});
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key) || map.get(key).size() < 1) return "";

        List<String[]> times = map.get(key);

        int l = 0;
        int r = times.size() - 1;

        int maxIndex = -1;

        while(l <= r){
            int m = (l + r) / 2;
            int tempTime = Integer.valueOf(times.get(m)[1]);
            if(tempTime <= timestamp){
                maxIndex = Math.max(maxIndex, m);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return maxIndex != -1 ? times.get(maxIndex)[0] : "";
    }
}
