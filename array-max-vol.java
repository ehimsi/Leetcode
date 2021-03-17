class Scratch {
    public static void main(String[] args) {
        //int[] a = { 7, 1, 2, 3, 9 };
        int[] a = { 6, 9, 3, 4, 5, 8 };
        int i = 0;
        int max = 0;
        for (i = 0; i < a.length; i++) {
            for(int j=0; j< a.length; j++){
                if (i == 0) {
                    max = Math.min(a[i], a[j]);
                } else if (max < (Math.abs(j-i) * Math.min(a[i], a[j]))) {
                    max = (Math.abs(j-i) * Math.min(a[i], a[j]));
                }
            }
        }
        System.out.println(max);
    }
}