package library;

import java.util.*;

public class BinaryTree {
	Node root;

	public BinaryTree(Gender key) {
		root = new Node(key);
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public boolean isEmpty() {

		return root == null;

	}

	public void insert(Gender genero) {
		Node newNode = new Node(genero);
		if (root == null) {
			root = newNode;
		}
		addNode(newNode, root);
	}

	private void addNode(Node newNode, Node node) {

		if (newNode.getKey() != node.getKey()) {
			if (newNode.getKey().getname().compareTo(node.getKey().getname()) > 1) {
				if (node.getLeft() != null) {
					addNode(newNode, node.getLeft());
				} else {
					node.setLeft(newNode);
				}
			} else {
				if (node.getRight() != null) {
					addNode(newNode, node.getRight());
				} else {
					node.setRight(newNode);
				}
			}
		}
	}

	public boolean hasElem(Gender elem) {
		return hasElem(root, elem);
	}

	private boolean hasElem(Node node, Gender elem) {

		if (node != null) {
			Gender currentKey = node.getKey();
			if (elem == currentKey) {
				return true;
			} else {
				if (elem.compareTo(currentKey.getname()) < 1) {
					return hasElem(node.getLeft(), elem);
				} else if (elem.compareTo(currentKey.getname()) > 1) {
					return hasElem(node.getRight(), elem);
				}
			}
		}
		return false;
	}

	public void printInOrder() {
		if (!isEmpty()) {
			printInOrder(root);
		}
	}

	private void printInOrder(Node node) {

		if (node.getLeft() != null) {
			printInOrder(node.getLeft());
		}
		System.out.println(node.toString());
		if (node.getRight() != null) {
			printInOrder(node.getRight());
		}

	}

	public void printPostOrder() {
		if (!isEmpty()) {
			printPostOrder(root);
		}
	}

	private void printPostOrder(Node node) {
		if (node.getLeft() != null) {
			printPostOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			printPostOrder(node.getRight());
		}
		System.out.println(node.toString());
	}

	public void printPreOrder() {
		if (!isEmpty()) {
			printPreOrder(root);
		}
	}

	private void printPreOrder(Node node) {
		System.out.println(node.toString());
		if (node.getLeft() != null) {
			printPreOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			printPreOrder(node.getRight());
		}
	}

	public boolean delete(Gender elem) {

		Gender rootKey = root.getKey();

		if (hasElem(elem)) {
			if (rootKey == elem) {
				root = null;
				return true;
			}
			return delete(root, elem);
		}
		return false;
	}

	private boolean delete(Node currentNode, Gender elem) {

		Node left = currentNode.getLeft();
		Node right = currentNode.getRight();

		if (currentNode.getKey().compareTo(elem.getname()) > 1) {
			if (left.getKey() == elem) {
				currentNode.setLeft(removeNode(left));
				return true;
			} else {
				return delete(left, elem);
			}
		} else {
			if (right.getKey() == elem) {
				currentNode.setRight(removeNode(right));
				return true;
			} else {
				return delete(right, elem);
			}
		}

	}

	private Node removeNode(Node targetNode) {
		if (targetNode.noChilds()) {
			return null;
		}
		if (targetNode.hasAChild()) {
			return targetNode.getAChild();
		}
		Node nmi = getNMI(targetNode.getLeft());
		delete(targetNode, nmi.getKey());
		nmi.setLeft(targetNode.getLeft());
		nmi.setRight(targetNode.getRight());
		return nmi;
	}

	// Nodo mayor izquierdo del arbol derecho
	private Node getNMI(Node node) {

		if (node.getRight() == null) {
			return node;
		}
		return getNMI(node.getRight());
	}

	public int getHeight() {

		int level = -1;
		int maxHeight = -1;

		if (isEmpty()) {
			return maxHeight;
		}
		return getHeight(root, level, maxHeight);

	}

	private int getHeight(Node node, int level, int maxHeight) {

		level++;
		if (node.noChilds()) {
			if (level > maxHeight) {
				maxHeight = level;
			}
		} else {
			if (node.getLeft() != null) {
				maxHeight = getHeight(node.getLeft(), level, maxHeight);
			}
			if (node.getRight() != null) {
				maxHeight = getHeight(node.getRight(), level, maxHeight);
			}
		}
		return maxHeight;

	}

	public List<Node> getFrontera() {

		if (!isEmpty()) {
			List<Node> frontera = new LinkedList<Node>();
			return getFrontera(root, frontera);
		}
		return null;

	}

	private List<Node> getFrontera(Node currentNode, List<Node> frontera) {

		Node left = currentNode.getLeft();
		Node right = currentNode.getRight();

		if (currentNode.noChilds()) {
			frontera.add(currentNode);
		} else {
			if (left != null) {
				frontera = getFrontera(left, frontera);
			}
			if (right != null) {
				frontera = getFrontera(right, frontera);
			}
		}
		return frontera;
	}

	public Node getMaxElem() {

		if (!isEmpty()) {
			return getMaxElem(root);
		}
		return null;
	}

	private Node getMaxElem(Node currentNode) {

		if (currentNode.getRight() != null) {
			return getMaxElem(currentNode.getRight());
		}
		return currentNode;
	}

	public List<Node> getElemAtLevel(int targetLevel) {

		if (getHeight() >= targetLevel) {
			List<Node> elements = new LinkedList<Node>();
			if (targetLevel == 0) {
				elements.add(root);
				return elements;
			}
			int currentLevel = -1;
			return getElemAtLevel(root, targetLevel, currentLevel, elements);
		}
		return null;
	}

	private List<Node> getElemAtLevel(Node node, int targetlevel, int currentLevel, List<Node> elements) {

		Node left = node.getLeft();
		Node right = node.getRight();
		currentLevel++;
		if (currentLevel == targetlevel - 1) {
			if (left != null) {
				elements.add(left);
			}
			if (right != null) {
				elements.add(right);
			}
		} else {
			if (left != null) {
				elements = getElemAtLevel(left, targetlevel, currentLevel, elements);
			}
			if (right != null) {
				elements = getElemAtLevel(right, targetlevel, currentLevel, elements);
			}
		}
		return elements;
	}

	public LinkedList<Node> getLongestBranch() {

		if (!isEmpty()) {
			return getLongestBranch(root);
		}
		return null;
	}

	private LinkedList<Node> getLongestBranch(Node node) {

		LinkedList<Node> lb = new LinkedList<Node>();
		if (node != null) {
			lb.add(node);
			Node left = node.getLeft();
			Node right = node.getRight();

			if (left != null || right != null) {
				LinkedList<Node> lbl = getLongestBranch(left);
				LinkedList<Node> lbr = getLongestBranch(right);
				if (lbl.size() > lbr.size()) {
					lb.addAll(lbl);
				} else {
					lb.addAll(lbr);
				}
			}

			return lb;
		}
		return lb;

	}
}
