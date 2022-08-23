public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // the new item is greater - insert after current item
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // the new item is less - insert before current item
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // the node with a previous IS null - is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // items are equal
                System.out.println(newItem.getValue() + " is already present in list, adding not needed.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem itemToRemove) {
        if (itemToRemove != null) {
            System.out.println("Attempting to remove " + itemToRemove.getValue() + " ...");
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(itemToRemove);
            if (comparison == 0) {
                // we found our match and we need determine is it the root
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {
                // all entries past this point should be greater than the item to remove
                // so the item to remove is NOT present in the list as we would have
                // found it already...
                System.out.println("Could not delete " + itemToRemove.getValue() + ", this item was not in the list.");
                return false;
            }
        }
        System.out.println("Could not remove...");
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty...");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }
}
