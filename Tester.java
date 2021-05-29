/**
 * Merge Sort Challenge Program
 * 5-22-2021
 * Ryan Wagner
 */
public class Tester
{
    public static void main(String[] args){
        StoreItem[] items = new StoreItem[10];
        items[0] = new StoreItem("Milk", "5834", 1.99, 25);
        items[1] = new StoreItem("Eggs", "4664", .99, 30);
        items[2] = new StoreItem("Bread", "2721", 1.49, 20);
        items[3] = new StoreItem("Cerial", "7946", 2.99, 15);
        items[4] = new StoreItem("Apple", "1245", .25, 12);
        items[5] = new StoreItem("Soda", "5451", 4.99, 10);
        items[6] = new StoreItem("Sandwich Meat", "8644", 1.99, 20);
        items[7] = new StoreItem("Butter", "1387", 1.99, 5);
        items[8] = new StoreItem("Cheese", "8965", 2.99, 12);
        items[9] = new StoreItem("Banana", "9876", .29, 10);
        
        printInventory(items);
        
        //mergeSortName(items, 0, items.length-1);
        //System.out.println("\n\nSorted by Name of Item\n");
        //printInventory(items);
        
        //mergeSortNumber(items, 0, items.length-1);
        //System.out.println("\n\nSorted by Product Number\n");
        //printInventory(items);
        
        //insertionSortPrice(items, 2);
        
        //selectionSortQuantity(items, 2);
    }
    
    public static void printInventory(StoreItem[] items){
        System.out.printf("%-15s %-20s %s %13s\n\n", "Item", "Product Number", "Price", "Quantity");
        for(StoreItem s: items){
            System.out.println(s);
        }
    }
    
    public static void mergeSortName(StoreItem[] items, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortName(items, low, mid);
        mergeSortName(items, mid+1, high);
        mergeSortName(items, low, mid, high);
    }
    
    public static void mergeSortName(StoreItem[] items, int low, int mid, int high){
        StoreItem[] temp = new StoreItem[high-low+1];
        int i = low, j = mid+1, n = 0;
        while(i <= mid || j <= high){
            if(i > mid){
                temp[n] = items[j];
                j++;
            }
            else if(j > high){
                temp[n] = items[i];
                i++;
            }
            else if(items[i].getName().compareTo(items[j].getName()) < 0){
                temp[n] = items[i];
                i++;
            }
            else{
                temp[n] = items[j];
                j++;
            }
            n++;
        }
        
        for(int k = low; k <= high; k++){
            items[k] = temp[k-low];
        }
    }
    
    public static void mergeSortNumber(StoreItem[] items, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortNumber(items, low, mid);
        mergeSortNumber(items, mid+1, high);
        mergeSortNumber(items, low, mid, high);
    }
    
    public static void mergeSortNumber(StoreItem[] items, int low, int mid, int high){
        StoreItem[] temp = new StoreItem[high-low+1];
        int i = low, j = mid+1, n = 0;
        while(i <= mid || j <= high){
            if(i > mid){
                temp[n] = items[j];
                j++;
            }
            else if(j > high){
                temp[n] = items[i];
                i++;
            }
            else if(items[i].getProductNumber().compareTo(items[j].getProductNumber()) < 0){
                temp[n] = items[i];
                i++;
            }
            else{
                temp[n] = items[j];
                j++;
            }
            n++;
        }
        
        for(int k = low; k <= high; k++){
            items[k] = temp[k-low];
        }
    }
    
    /**
     * enter 1 for ascending or 2 for descending
     */
    public static void insertionSortPrice(StoreItem[] items, int ascOrDes){
        double[] prices = new double[items.length];
        StoreItem[] newItems = new StoreItem[items.length];
        if(ascOrDes == 1){
            for(int i = 0 ; i < items.length ; i++ ){
                double next = items[i].getPrice();
                int newIndex = 0, t = i;
                while(t > 0 && newIndex == 0){
                    if (next > prices[t - 1]){
                        newIndex = t;
                    }
                    else{
                        prices[t] = prices[t-1];
                        newItems[t] = newItems[t-1];
                    }
                    t--;
                }
                prices[newIndex] = next;
                newItems[newIndex] = items[i];
            }
            System.out.println("\n\nSorted by price from least to greatest\n");
        }
        if(ascOrDes == 2){
            for(int i = 0 ; i < items.length ; i++ ){
                double next = items[i].getPrice();
                int newIndex = 0, m = i;
                while(m > 0 && newIndex == 0){
                    if(next < prices[m - 1]){
                        newIndex = m;
                    }
                    else{
                        prices[m] = prices[m-1];
                        newItems[m] = newItems[m-1];
                    }
                    m--;
                }
                prices[newIndex] = next;
                newItems[newIndex] = items[i];
            }
            System.out.println("\n\nSorted by price from greatest to least\n");
        }
        for(StoreItem i: newItems){
            System.out.println(i);
        }
    }
    
    /**
     * enter 1 for ascending or 2 for descending
     */
    public static void selectionSortQuantity(StoreItem[] items, int ascOrDes){
        int index = 0;
        StoreItem altItem = new StoreItem("", "", 0, 0);
        if(ascOrDes == 1){
            for(int i = items.length - 1; i > 0; i--){
                index = 0;
                for(int j = 1; j <= i; j++){
                    if(items[j].getQuantity() > items[index].getQuantity()){
                        index = j;
                    }
                    altItem = items[i];
                    items[i] = items[index];
                    items[index] = altItem;
                }
            }
            System.out.println("\n\nSorted by quantity from least to greatest\n");
            for(StoreItem i: items){
                System.out.println(i);
            }
        }
        
        if(ascOrDes == 2){
            for(int i = items.length - 1; i > 0; i--){
                index = 0;
                for(int j = 1; j <= i; j++){
                    if(items[j].getQuantity() < items[index].getQuantity()){
                        index = j;
                    }
                    altItem = items[i];
                    items[i] = items[index];
                    items[index] = altItem;
                }
            }
            System.out.println("\n\nSorted by quantity from greatest to least\n");
            for(StoreItem i: items){
                System.out.println(i);
            }
        }
    }
}
