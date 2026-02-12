package edu.unl.raikes.BinarySearchTreeLab;

/**
 * A Binary Search Tree class for Person objects.
 */
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    /**
     * Inserts a person object into the tree.
     * 
     * @param data The person object.
     */
    public void insert(Person data) {
        boolean inserted = false;
        // If the tree is empty, set the root to the new person.
        if (root == null) {
            root = new BinarySearchNode(data);
            inserted = true;
        } // Otherwise go through the tree recursively and insert it into the tree.
        else {
            inserted = root.insert(data);
        } // If it was inserted successfully, increment the size.
        if (inserted) {
            size++;
        }
    }

    /**
     * Find a Person node by its key.
     * 
     * @param  key The key to search by.
     * @return     The person node.
     */
    public Person search(int key) {
        // If the root is null, there are no elements, so return null.
        if (root == null) {
            return null;
        }
        // Recurse the search.
        BinarySearchNode found = root.search(key);
        // Return the person data if it was found, otherwise return null.
        if (found != null) {
            return found.person;
        } else {
            return null;
        }

    }

    /**
     * Deletes a Person node from the tree.
     * 
     * @param  key The key of the node to delete.
     * @return     The Person node being deleted.
     */
    public Person delete(int key) {
        Person deleted = null;

        // If root is null, there are no elements in the tree, so return null.
        if (root == null) {
            return null;
        } // Otherwise, recurse to delete item.
        else {
            // Check if the root node is the node to delete.
            if (root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(root);
                // Save the deleted node.
                deleted = root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                root = auxRoot.leftChild;
                // If the root is still null, nullify the tree.
                if (root != null)
                    root.parent = null;
            } // For the basic case without root shenanigans, delete the node through recursion.
            else {
                deleted = root.delete(key);
            } // If the deleted item was found and removed, decrement the size.
            if (deleted != null)
                size--;
            return deleted;
        }
    }

    /**
     * Gets a string containing the contents of this tree.
     * 
     * @return a string representation of this tree.
     */
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + this.size + "\n";
        // Print the tree if the tree exists.
        if (this.root != null) {
            toReturn += this.root.toString();
        }
        return toReturn;
    }

}
