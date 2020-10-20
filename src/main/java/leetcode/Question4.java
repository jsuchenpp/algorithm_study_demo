package leetcode;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2020年9月24日
 */
public class Question4 {
    public static void main(String[] args) {
        int[] customers = new int[] {8,3};
        System.out.println(minOperationsMaxProfit(customers, 5, 6));
        
//        int[] customers = new int[] {10,9,6};
//        System.out.println(minOperationsMaxProfit(customers, 6, 4));
        
//      int[] customers = new int[] {3,4,0,5,1};
//      System.out.println(minOperationsMaxProfit(customers, 1, 92));
        
//      int[] customers = new int[] {10,10,6,4,7};
//      System.out.println(minOperationsMaxProfit(customers, 3, 8));
    }
    
    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        long dengcang = 0L;
        long dengdai = 0L;
        
        int tang = 1;
        long lirun = 0L;
        long maxlirun = 0L;
        int maxliruntang = 1;
        for (int i = 0; i < customers.length; i++) {
            // 等待人数= 上次等待人数+本次达到人数
            dengdai += customers[i];
            
            if(dengdai >= 4) {
                // 登舱人数
                dengcang += 4;
                // 等待人数= 上次等待人数+本次达到人数
                dengdai -= 4;
                lirun = dengcang * boardingCost - tang * runningCost;
                if(lirun > maxlirun) {
                    maxlirun = lirun;
                    maxliruntang = tang;
                }
                tang ++;
                System.out.println(customers[i] + " 位游客抵达，"+dengcang+" 位登舱，"+dengdai+" 位等待，摩天轮轮转。当前利润为 "+dengcang+" * $"+boardingCost+" - "+tang+" * $"+runningCost+" = $"+lirun+" 。");
            } else {
                // 登舱人数
                dengcang += dengdai;
                // 等待人数= 上次等待人数+本次达到人数
                dengdai = 0;
                lirun = dengcang * boardingCost - tang * runningCost;
                if(lirun > maxlirun) {
                    maxlirun = lirun;
                    maxliruntang = tang;
                }
                tang ++;
                System.out.println(customers[i] + " 位游客抵达，"+dengcang+" 位登舱，"+dengdai+" 位等待，摩天轮轮转。当前利润为 "+dengcang+" * $"+boardingCost+" - "+tang+" * $"+runningCost+" = $"+lirun+" 。");
            }
        }
        
        if(dengdai > 0) {
            long loop = ((dengdai - (dengdai % 4)) / 4) + 1;
            for(int i = 0; i < loop; i++) {
                if(dengdai >= 4) {
                    // 登舱人数
                    dengcang += 4;
                    // 等待人数= 上次等待人数+本次达到人数
                    dengdai -= 4;
                    lirun = dengcang * boardingCost - tang * runningCost;
                    if(lirun > maxlirun) {
                        maxlirun = lirun;
                        maxliruntang = tang;
                    }
                    tang ++;
                    System.out.println("0 位游客抵达，"+dengcang+" 位登舱，"+dengdai+" 位等待，摩天轮轮转。当前利润为 "+dengcang+" * $"+boardingCost+" - "+tang+" * $"+runningCost+" = $"+lirun+" 。");
                } else {
                    // 登舱人数
                    dengcang += dengdai;
                    // 等待人数= 上次等待人数+本次达到人数
                    dengdai = 0;
                    lirun = dengcang * boardingCost - tang * runningCost;
                    if(lirun > maxlirun) {
                        maxlirun = lirun;
                        maxliruntang = tang;
                    }
                    tang ++;
                    System.out.println("0 位游客抵达，"+dengcang+" 位登舱，"+dengdai+" 位等待，摩天轮轮转。当前利润为 "+dengcang+" * $"+boardingCost+" - "+tang+" * $"+runningCost+" = $"+lirun+" 。");
                }
            }
        }
        
        if(lirun < 0L) {
            return  -1;
        }
        return maxliruntang;
    }
}
