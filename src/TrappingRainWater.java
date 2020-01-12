public class TrappingRainWater {
    public int trap(int[] height) {
        if (height==null || height.length < 2) {
            return 0;
        }
        int n = height.length;

        int wc = 0;

        int l = 0; int r = n-1;
        int mxlw = 0; int mxrw = 0;
        while (l < r) {
            int lw = height[l];
            int rw = height[r];

            if (lw <= rw) {
                if (lw > mxlw) {
                    mxlw = lw;
                } else {
                    wc += mxlw - lw;
                }
                l++;
            } else {
                if (rw > mxrw) {
                    mxrw = rw;
                } else {
                    wc += mxrw - rw;
                }
                r--;
            }
        }
        return wc;
    }

    public static void main(String[] args) {
        TrappingRainWater tw = new TrappingRainWater();
        int ans = tw.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(ans);
    }
}

