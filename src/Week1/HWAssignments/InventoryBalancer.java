package Week1.HWAssignments;

public class InventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0, sumB = 0;
        int maxQty = -1;
        String maxSection = "";
        int maxItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            sumB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                sumA, sumB, status, maxQty, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        // Test Case
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
