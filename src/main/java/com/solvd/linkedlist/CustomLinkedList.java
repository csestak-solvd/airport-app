package com.solvd.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList<T> {
    public Node<T> head;

    // Add a new node with the given data to the end of the linked list.
    public void add(T data) {
        // Create a new node with the provided data.
        Node<T> newNode = new Node<T>(data);
        // If the list is empty, set the new node as the head.
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the list to find the last node.
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Add the new node as the next node to the last node.
            current.next = newNode;
        }
    }

    // Remove the first occurrence of a node with the given data from the linked list.
    public void remove(T data) {
        // If the list is empty, no action is needed.
        if (head == null) {
            return;
        }
        // If the node to be removed is the head, update the head to the next node.
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        // Traverse the list to find the node before the one to be removed.
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        // If the node to be removed is found, update the pointers to exclude it from the list.
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public List<T> getAll() {
        // Create a new ArrayList to store the elements of the linked list.
        List<T> resultList = new ArrayList<>();
        // Start from the head of the linked list.
        Node<T> current = head;

        // Traverse the linked list until the end (current becomes null).
        while (current != null) {
            // Add the data of the current node to the result list.
            resultList.add(current.data);
            // Move to the next node in the linked list.
            current = current.next;
        }
        // Return the list containing all elements of the linked list.
        return resultList;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
