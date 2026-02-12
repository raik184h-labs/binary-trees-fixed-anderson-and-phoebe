package edu.unl.raikes.BinarySearchTreeLab;

/**
 * A class to construct a binary search tree with.
 */
class BinarySearchNode {
    protected BinarySearchNode parent;
    protected BinarySearchNode leftChild;
    protected BinarySearchNode rightChild;
    protected Person person;

    /**
     * A binary node for a binary search tree that contains person data.
     * 
     * @param person The data for the node to contain.
     */
    BinarySearchNode(Person person) {
        this.person = person;
    }

    /**
     * Inserts a new node in the appropriate position in the binary tree.
     * 
     * @param  data The data to be in the new node.
     * @return      true if successfully inserted.
     */
    boolean insert(Person data) {
        // Return false if data is already within the tree.
        if (data == this.person) {
            return false;
        }
        // Check the left child tree recursively.
        else if (Integer.compare(data.key, person.key) < 0) {
            // If the child is empty, set it to the new node.
            if (leftChild == null) {
                setLeftChild(new BinarySearchNode(data));
                return true;
            } // Otherwise continue along the left tree.
            else {
                return leftChild.insert(data);
            }
        }
        // Check the right child tree recursively.
        else if (Integer.compare(data.key, person.key) > 0) {
            // If the child is empty, set it to the new node.
            if (rightChild == null) {
                setRightChild(new BinarySearchNode(data));
                return true;
            } // Otherwise continue along the right tree.
            else {
                return rightChild.insert(data);
            }
        }
        return false;
    }

    /**
     * Find the node in the tree by its key.
     * 
     * @param  key The key to search by.
     * @return     The node with the given key.
     */
    BinarySearchNode search(int key) {
        // Recursively search the left child.
        if (leftChild != null && Integer.compare(key, person.key) < 0) {
            return leftChild.search(key);
        }
        // Recursively search the right child.
        else if (rightChild != null && Integer.compare(key, person.key) > 0) {
            return rightChild.search(key);
        }
        // Return the node if the key matches.
        else if (this.person.key == key) {
            return this;
        }
        // Return null if the node's key is not in the tree.
        else {
            return null;
        }
    }

    /**
     * Deletes the node associated with this key.
     * 
     * @param  key The key of the node to delete.
     * @return     The data of the deleted node.
     */
    Person delete(int key) {
        // Find the node to delete
        BinarySearchNode node = search(key);
        if (node == null)
            return null;
        Person deleted = node.person;

        // If both children are null, set parent reference to null.
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent.leftChild == node)
                node.parent.setLeftChild(null);
            else if (node.parent.rightChild == node)
                node.parent.setRightChild(null);
        }
        // If the node has two non-null children, update the tree by setting the minimum node of the right child to the
        // deleted nodes position in the tree.
        else if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode min = node.rightChild.getNodeWithMinValue();
            node.person = min.person;
            int minKey = min.person.key;
            min.delete(minKey);
        }
        // If the node is the left child of its parent, set its parent's left child to its non-null child node.
        else if (node.parent.leftChild == node) {
            BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setLeftChild(newLeftChild);
        }
        // If the node is the right child of its parent, set its parent's right child to its non-null child node.
        else if (node.parent.rightChild == node) {
            BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setRightChild(newRightChild);
        }

        return deleted;
    }

    /**
     * Get the node with the smallest value using this node as a root.
     * 
     * @return The smallest valued node.
     */
    BinarySearchNode getNodeWithMinValue() {
        if (this.leftChild == null) {
            return this;
        } else {
            return this.leftChild.getNodeWithMinValue();
        }
    }

    /**
     * Sets the left child of this node to the given node.
     * 
     * @param child The node to set.
     */
    void setLeftChild(BinarySearchNode child) {
        this.leftChild = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * Sets the right child of this node to the given node.
     * 
     * @param child The node to set.
     */
    void setRightChild(BinarySearchNode child) {
        this.rightChild = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * Gets a string representation of this Node which includes all of its child nodes.
     * 
     * @return a string representation of this Node.
     */
    public String toString() {
        String toReturn = "";

        // Recursively prints all child nodes.
        if (this.leftChild != null) {
            toReturn += "  " + this.leftChild.toString();
        }

        toReturn += "  " + this.person.toString() + "\n";

        if (this.rightChild != null) {
            toReturn += "  " + this.rightChild.toString();
        }
        return toReturn;
    }

}
