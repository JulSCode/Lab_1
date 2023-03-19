package firstlab;

/**
 * Class of container node
 */
class ContainerElement
{
    /**
     * the next node
     */
    public ContainerElement next;
    /**
     * the node information
     */
    public Integer number;
}
/**
 * Container class
 */
public class MyContainer
{
    /**
     * the base of a linked list container
     * first node
     */
    private ContainerElement first;
    /**
     * last node
     */
    private ContainerElement last;
    /**
     * container size
     */
    private int size = 0;

    /**
     * The function of adding an element to the head of the container
     * @param number item to add
     */
    public void addToHead(Integer number)
    {
        ContainerElement ce = new ContainerElement();
        ce.number = number;
        size++;

        if(first == null)
        {
            first = ce;
            last = ce;
            last.next = null;
        }
        else
        {
            ce.next = first;
            first = ce;
        }
    }
    /**
     * The function of adding an element to the tail of the container
     * @param number item to add
     */
    public void addToTail(Integer number)
    {
        ContainerElement ce = new ContainerElement();
        ce.number = number;
        size++;

        if (last == null)
        {
            first = ce;
            last = ce;
        }
        else
        {
            last.next = ce;
            last = ce;
            last.next = null;
        }
    }

    /**
     * The function of adding an element to the index in the container
     * @param index place in container to add
     * @param number item to add
     */
    public void addToIndex(int index, Integer number)
    {
        if (index >= size || index < 0)
            return;

        ContainerElement ce = new ContainerElement();
        ce.number = number;
        size++;

        ContainerElement fe = this.first;
        for (int i = 0; i < index - 1; i++)
            fe = fe.next;

        ce.next = fe.next;
        fe.next = ce;
    }

    /**
     * Method for getting the container size
     * @return size of the container
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Method for printing all elements of list
     */
    public void printContainer()
    {
        ContainerElement ce = this.first;
        while (ce != null)
        {
            System.out.print(ce.number + " ");
            ce = ce.next;
        }
        System.out.println();
    }

    /**
     * Method for getting the head element value
     * @return the value of the first node
     */
    public Integer getFirst()
    {
        return first.number;
    }

    /**
     * Method for getting the tail element value
     * @return the value of the last node
     */
    public Integer getLast()
    {
        return last.number;
    }

    /**
     * Method for getting the element value
     * @param index index of the element to get the value
     * @return value of the node with the given index
     */
    public Integer get(int index)
    {
        if (first == null || index >= size || index < 0)
            return null;

        int counter = 0;
        ContainerElement ce = first;
        while (ce != null)
        {
            if (counter == index)
            {
                return ce.number;
            }
            ce = ce.next;
            counter++;
        }
        return null;
    }

    /**
     * Method of deleting a head node
     */
    public void removeFirst()
    {
        first = first.next;
        size--;
    }
    
    /**
     * Method of deleting a tail node
     */
    public void removeLast()
    {
        ContainerElement ce = first;
        while (ce.next.next != null)
            ce = ce.next;
        last = ce;
        ce.next = null;
        size--;
    }

    /**
     * Method of deleting a node with selected index
     * @param index index of the node to delete
     */
    public void remove(int index)
    {
        if (first == null || index >= size || index < 0)
            return;

        ContainerElement ce = first;

        if (index == 0)
        {
            if (ce.next == null)
            {
                first = null;
                last = null;
            }
            else
                first = ce.next;
            size--;
            return;
        }

        int counter = 1;

        while (ce.next != null)
        {
            if (counter == index)
            {
                ce.next = ce.next.next;
                if(last == ce.next)
                    last = ce;
                size--;
                return;
            }
            ce = ce.next;
            counter++;
        }
    }

    /**
     * Method of deleting all nodes with selected numbers
     * @param number numbers of nodes to delete
     */
    public void removeElements(Integer number)
    {
        if (first == null)
            return;

        while (first.number == number)
        {
            first = first.next;
            size--;
        }

        ContainerElement ce = first;

        while (ce.next != null)
        {
            if (ce.next.number == number)
            {
                ce.next = ce.next.next;
                if(last == ce.next)
                    last = ce;
                size--;
            }
            else
                ce = ce.next;
        }
    }

    /**
     * Method of finding a first index of node with selected number
     * @param number node number to find
     * @return found node index
     */
    public Integer firstIndexOf(Integer number)
    {
        ContainerElement ce = first;
        int counter = 0;

        while (ce != null)
        {
            if (ce.number == number)
                return counter;
            else
                ce = ce.next;
            counter++;
        }
       return null;
    }

    /**
     * Method of finding a last index of node with selected number
     * @param number node number to find
     * @return found node index
     */
    public Integer lastIndexOf(Integer number)
    {
        ContainerElement ce = first;
        int counter = 0;
        Integer result = null;

        while (ce != null)
        {
            if (ce.number == number)
                result = counter;
            ce = ce.next;
            counter++;
        }
        return result;
    }

    /**
     * Method of clearing a container which deletes all nodes
     */
    public void clear()
    {
        first.next = null;
        first.number = null;
        last.number = null;
        size = 0;
    }

    /**
     * Method of transforming list to array
     * @return an array with the same numbers as in list
     */
    public int [] toArray()
    {
        ContainerElement ce = first;
        int [] result;
        result = new int[size];
        for (int i = 0; i<size; i++)
        {
            result[i]= ce.number;
            ce = ce.next;
        }
        return result;
    }
}
