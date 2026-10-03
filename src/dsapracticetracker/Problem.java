package dsapracticetracker;

import java.io.Serializable;

/*
 * Represents one DSA problem.
 *
 * Serializable allows us to save Problem objects
 * into a file and load them again when the program starts.
 */
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String topic;
    String difficulty;
    boolean solved;

    // Constructor
    public Problem(int id, String name, String topic,
                   String difficulty, boolean solved) {

        this.id = id;
        this.name = name;
        this.topic = topic;
        this.difficulty = difficulty;
        this.solved = solved;
    }
}