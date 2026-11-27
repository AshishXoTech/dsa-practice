class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
                int n = items.length;

        int[] benefit = new int[n];

        // Step 1: Calculate benefit of every item

        for (int i = 0; i < n; i++) {

            int freeCount = 0;

            for (int j = 0; j < n; j++) {

                if (i != j &&

                    items[j][0] % items[i][0] == 0) {

                    freeCount++;

                }

            }

            benefit[i] = 1 + freeCount;

        }

        // Group items by price

        List<Integer>[] groups = new ArrayList[budget + 1];

        for (int i = 0; i <= budget; i++) {

            groups[i] = new ArrayList<>();

        }

        for (int i = 0; i < n; i++) {

            int price = items[i][1];

            if (price <= budget) {

                groups[price].add(i);

            }

        }

        // dpAny[c]: best benefit using higher-price items

        int[] dpAny = new int[budget + 1];

        int ans = 0;

        // Step 2: Process prices from high to low

        for (int p = budget; p >= 1; p--) {

            if (groups[p].isEmpty()) {

                continue;

            }

            // Must select at least one item of price p

            int[] dpWith = new int[budget + 1];

            Arrays.fill(dpWith, -1000000);

            // Step 3: Process current price group

            for (int idx : groups[p]) {

                int value = benefit[idx];

                for (int c = budget; c >= p; c--) {

                    dpWith[c] = Math.max(

                        dpWith[c],

                        Math.max(

                            dpWith[c - p] + value,

                            dpAny[c - p] + value

                        )

                    );

                }

            }

            // Step 4: Calculate answer

            for (int c = p; c <= budget; c++) {

                if (dpWith[c] >= 0) {

                    int extra = (budget - c) / p;

                    ans = Math.max(

                        ans,

                        dpWith[c] + extra

                    );

                }

            }
            // Step 5: Add current group to dpAny
            for (int idx : groups[p]) {
                int value = benefit[idx];
                for (int c = budget; c >= p; c--) {
                    dpAny[c] = Math.max(
                        dpAny[c],
                        dpAny[c - p] + value
                    );
                }
            }
        }
        return ans;
    }
}