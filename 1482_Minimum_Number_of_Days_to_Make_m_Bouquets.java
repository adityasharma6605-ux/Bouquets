class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long required=(long)m*k;
        if(required>bloomDay.length){
            return -1;
        }
        int min=bloomDay[0];
        int max=bloomDay[0];
        for(int day:bloomDay){
            min=Math.min(min,day);
            max=Math.max(max,day);
        }
        while(min<=max){
            int mid=min+(max-min)/2;
            int flowers=0;
            int bouquet=0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid){
                    flowers++;
                    if(flowers==k){
                        bouquet++;
                        flowers=0;
                    }
                }
                else{
                    flowers=0;
                }
            }
            if(bouquet>=m){
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
}
