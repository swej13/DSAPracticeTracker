package dsapracticetracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DSAPracticeTracker {

    // File where all problems will be stored
    static final String FILE_NAME = "dsa_problems.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load saved problems
        ArrayList<Problem> problems = loadProblems();

        int choice;

        do {

            System.out.println();
            System.out.println("=================================================");
            System.out.println("             DSA PRACTICE TRACKER");
            System.out.println("=================================================");
            System.out.println("1.  Add Problem");
            System.out.println("2.  View All Problems");
            System.out.println("3.  Search Problem");
            System.out.println("4.  Mark Problem as Solved");
            System.out.println("5.  Filter by Topic");
            System.out.println("6.  Filter by Difficulty");
            System.out.println("7.  Update Problem");
            System.out.println("8.  Delete Problem");
            System.out.println("9.  Show Progress");
            System.out.println("10. DSA Algorithms");
            System.out.println("11. Save Problems");
            System.out.println("12. Exit");
            System.out.println("=================================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // =================================================
                // 1. ADD PROBLEM
                // =================================================
                case 1:

                    System.out.println();
                    System.out.println("---------- ADD NEW PROBLEM ----------");

                    System.out.print("Enter Problem ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean idExists = false;

                    for (Problem p : problems) {

                        if (p.id == id) {
                            idExists = true;
                            break;
                        }
                    }

                    if (idExists) {
                        System.out.println("Problem ID already exists!");
                        break;
                    }

                    System.out.print("Enter Problem Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Topic: ");
                    String topic = sc.nextLine();

                    System.out.print("Enter Difficulty (Easy/Medium/Hard): ");
                    String difficulty = sc.nextLine();

                    System.out.print("Is it solved? (true/false): ");
                    boolean solved = sc.nextBoolean();

                    Problem newProblem =
                            new Problem(id, name, topic, difficulty, solved);

                    problems.add(newProblem);

                    System.out.println("Problem added successfully!");

                    break;

                // =================================================
                // 2. VIEW ALL PROBLEMS
                // =================================================
                case 2:

                    System.out.println();
                    System.out.println("---------- ALL DSA PROBLEMS ----------");

                    if (problems.isEmpty()) {

                        System.out.println("No problems available.");

                    } else {

                        for (Problem p : problems) {
                            displayProblem(p);
                        }
                    }

                    break;

                // =================================================
                // 3. SEARCH PROBLEM
                // =================================================
                case 3:

                    System.out.println();
                    System.out.println("---------- SEARCH PROBLEM ----------");

                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Name");

                    System.out.print("Enter choice: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    if (searchChoice == 1) {

                        System.out.print("Enter Problem ID: ");
                        int searchId = sc.nextInt();

                        for (Problem p : problems) {

                            if (p.id == searchId) {

                                displayProblem(p);
                                found = true;
                                break;
                            }
                        }

                    } else if (searchChoice == 2) {

                        System.out.print("Enter Problem Name: ");
                        String searchName = sc.nextLine();

                        for (Problem p : problems) {

                            if (p.name.equalsIgnoreCase(searchName)) {

                                displayProblem(p);
                                found = true;
                                break;
                            }
                        }

                    } else {

                        System.out.println("Invalid search choice.");
                        break;
                    }

                    if (!found) {
                        System.out.println("Problem not found!");
                    }

                    break;

                // =================================================
                // 4. MARK PROBLEM AS SOLVED
                // =================================================
                case 4:

                    System.out.println();
                    System.out.println("---------- MARK AS SOLVED ----------");

                    System.out.print("Enter Problem ID: ");
                    int solveId = sc.nextInt();

                    boolean solveFound = false;

                    for (Problem p : problems) {

                        if (p.id == solveId) {

                            solveFound = true;

                            if (p.solved) {

                                System.out.println(
                                        "Problem is already solved!");

                            } else {

                                p.solved = true;

                                System.out.println(
                                        "Problem marked as solved!");
                            }

                            break;
                        }
                    }

                    if (!solveFound) {
                        System.out.println("Problem not found!");
                    }

                    break;

                // =================================================
                // 5. FILTER BY TOPIC
                // =================================================
                case 5:

                    System.out.println();
                    System.out.println("---------- FILTER BY TOPIC ----------");

                    System.out.print("Enter Topic: ");
                    String searchTopic = sc.nextLine();

                    boolean topicFound = false;

                    for (Problem p : problems) {

                        if (p.topic.equalsIgnoreCase(searchTopic)) {

                            displayProblem(p);
                            topicFound = true;
                        }
                    }

                    if (!topicFound) {

                        System.out.println(
                                "No problems found for this topic.");
                    }

                    break;

                // =================================================
                // 6. FILTER BY DIFFICULTY
                // =================================================
                case 6:

                    System.out.println();
                    System.out.println("---------- FILTER BY DIFFICULTY ----------");

                    System.out.print("Enter Difficulty: ");
                    String searchDifficulty = sc.nextLine();

                    boolean difficultyFound = false;

                    for (Problem p : problems) {

                        if (p.difficulty.equalsIgnoreCase(
                                searchDifficulty)) {

                            displayProblem(p);
                            difficultyFound = true;
                        }
                    }

                    if (!difficultyFound) {

                        System.out.println(
                                "No problems found for this difficulty.");
                    }

                    break;

                // =================================================
                // 7. UPDATE PROBLEM
                // =================================================
                case 7:

                    System.out.println();
                    System.out.println("---------- UPDATE PROBLEM ----------");

                    System.out.print("Enter Problem ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updateFound = false;

                    for (Problem p : problems) {

                        if (p.id == updateId) {

                            updateFound = true;

                            System.out.print(
                                    "Enter New Problem Name: ");
                            p.name = sc.nextLine();

                            System.out.print(
                                    "Enter New Topic: ");
                            p.topic = sc.nextLine();

                            System.out.print(
                                    "Enter New Difficulty: ");
                            p.difficulty = sc.nextLine();

                            System.out.print(
                                    "Is it solved? (true/false): ");
                            p.solved = sc.nextBoolean();

                            System.out.println(
                                    "Problem updated successfully!");

                            break;
                        }
                    }

                    if (!updateFound) {

                        System.out.println(
                                "Problem not found!");
                    }

                    break;

                // =================================================
                // 8. DELETE PROBLEM
                // =================================================
                case 8:

                    System.out.println();
                    System.out.println("---------- DELETE PROBLEM ----------");

                    System.out.print("Enter Problem ID: ");
                    int deleteId = sc.nextInt();

                    boolean deleteFound = false;

                    for (int i = 0; i < problems.size(); i++) {

                        if (problems.get(i).id == deleteId) {

                            problems.remove(i);

                            deleteFound = true;

                            System.out.println(
                                    "Problem deleted successfully!");

                            break;
                        }
                    }

                    if (!deleteFound) {

                        System.out.println(
                                "Problem not found!");
                    }

                    break;

                // =================================================
                // 9. SHOW PROGRESS
                // =================================================
                case 9:

                    System.out.println();
                    System.out.println("---------- YOUR DSA PROGRESS ----------");

                    int total = problems.size();
                    int solvedCount = 0;
                    int unsolvedCount = 0;

                    int easyCount = 0;
                    int mediumCount = 0;
                    int hardCount = 0;

                    for (Problem p : problems) {

                        if (p.solved) {
                            solvedCount++;
                        } else {
                            unsolvedCount++;
                        }

                        if (p.difficulty.equalsIgnoreCase("Easy")) {

                            easyCount++;

                        } else if (
                                p.difficulty.equalsIgnoreCase("Medium")) {

                            mediumCount++;

                        } else if (
                                p.difficulty.equalsIgnoreCase("Hard")) {

                            hardCount++;
                        }
                    }

                    System.out.println("-----------------------------------------");
                    System.out.println("Total Problems : " + total);
                    System.out.println("Solved         : " + solvedCount);
                    System.out.println("Not Solved     : " + unsolvedCount);
                    System.out.println("-----------------------------------------");

                    System.out.println("Easy           : " + easyCount);
                    System.out.println("Medium         : " + mediumCount);
                    System.out.println("Hard           : " + hardCount);
                    System.out.println("-----------------------------------------");

                    if (total > 0) {

                        double progress =
                                (solvedCount * 100.0) / total;

                        System.out.printf(
                                "Progress       : %.2f%%%n",
                                progress);

                    } else {

                        System.out.println(
                                "Progress       : 0%");
                    }

                    System.out.println("-----------------------------------------");

                    break;

                // =================================================
                // 10. DSA ALGORITHMS
                // =================================================
                case 10:

                    dsaMenu(sc);

                    break;

                // =================================================
                // 11. SAVE PROBLEMS
                // =================================================
                case 11:

                    saveProblems(problems);

                    break;

                // =================================================
                // 12. EXIT
                // =================================================
                case 12:

                    saveProblems(problems);

                    System.out.println();
                    System.out.println(
                            "Thank you for using DSA Practice Tracker!");

                    System.out.println(
                            "Keep solving DSA problems!");

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Please try again.");
            }

        } while (choice != 12);

        sc.close();
    }


    // =========================================================
    // DSA MENU
    // =========================================================
    static void dsaMenu(Scanner sc) {

        int choice;

        do {

            System.out.println();
            System.out.println("=================================================");
            System.out.println("                DSA ALGORITHMS");
            System.out.println("=================================================");
            System.out.println("1.  Array Operations");
            System.out.println("2.  Searching");
            System.out.println("3.  Sorting");
            System.out.println("4.  Stack");
            System.out.println("5.  Queue");
            System.out.println("6.  Linked List");
            System.out.println("7.  Tree");
            System.out.println("8.  Graph");
            System.out.println("9.  Back");
            System.out.println("=================================================");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("Array Operations:");
                    System.out.println("1. ArrayOperations.java");

                    runProgram("dsapracticetracker.ArrayOperations");

                    break;

                case 2:

                    System.out.println();
                    System.out.println("Searching:");
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");

                    System.out.print("Enter choice: ");
                    int searchChoice = sc.nextInt();

                    if (searchChoice == 1) {

                        runProgram(
                                "dsapracticetracker.LinearSearch");

                    } else if (searchChoice == 2) {

                        runProgram(
                                "dsapracticetracker.BinarySearch");

                    } else {

                        System.out.println("Invalid choice.");
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("Sorting:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Selection Sort");
                    System.out.println("3. Insertion Sort");
                    System.out.println("4. Merge Sort");
                    System.out.println("5. Quick Sort");
                    System.out.println("6. Heap Sort");

                    System.out.print("Enter choice: ");
                    int sortChoice = sc.nextInt();

                    switch (sortChoice) {

                        case 1:
                            runProgram(
                                    "dsapracticetracker.BubbleSort");
                            break;

                        case 2:
                            runProgram(
                                    "dsapracticetracker.SelectionSort");
                            break;

                        case 3:
                            runProgram(
                                    "dsapracticetracker.InsertionSort");
                            break;

                        case 4:
                            runProgram(
                                    "dsapracticetracker.MergeSort");
                            break;

                        case 5:
                            runProgram(
                                    "dsapracticetracker.QuickSort");
                            break;

                        case 6:
                            runProgram(
                                    "dsapracticetracker.HeapSort");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println("Stack:");
                    System.out.println("1. Stack Using Array");
                    System.out.println("2. Infix To Postfix");
                    System.out.println("3. Postfix Evaluation");
                    System.out.println("4. Balanced Brackets");
                    System.out.println("5. Palindrome Using Stack");
                    System.out.println("6. Reverse String Using Stack");

                    System.out.print("Enter choice: ");
                    int stackChoice = sc.nextInt();

                    switch (stackChoice) {

                        case 1:
                            runProgram(
                                    "dsapracticetracker.StackUsingArray");
                            break;

                        case 2:
                            runProgram(
                                    "dsapracticetracker.InfixToPostfix");
                            break;

                        case 3:
                            runProgram(
                                    "dsapracticetracker.PostfixEvaluation");
                            break;

                        case 4:
                            runProgram(
                                    "dsapracticetracker.BalancedBrackets");
                            break;

                        case 5:
                            runProgram(
                                    "dsapracticetracker.PalindromeUsingStack");
                            break;

                        case 6:
                            runProgram(
                                    "dsapracticetracker.ReverseStringUsingStack");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }

                    break;

                case 5:

                    System.out.println();
                    System.out.println("Queue:");
                    System.out.println("1. Queue Using Array");
                    System.out.println("2. Circular Queue");
                    System.out.println("3. Queue Using Linked List");

                    System.out.print("Enter choice: ");
                    int queueChoice = sc.nextInt();

                    switch (queueChoice) {

                        case 1:
                            runProgram(
                                    "dsapracticetracker.QueueArray");
                            break;

                        case 2:
                            runProgram(
                                    "dsapracticetracker.CircularQueue");
                            break;

                        case 3:
                            runProgram(
                                    "dsapracticetracker.QueueUsingLinkedList");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }

                    break;

                case 6:

                    System.out.println();
                    System.out.println("Linked List:");
                    System.out.println("1. Singly Linked List");
                    System.out.println("2. Doubly Linked List");
                    System.out.println("3. Circular Linked List");
                    System.out.println("4. Stack Using Linked List");

                    System.out.print("Enter choice: ");
                    int listChoice = sc.nextInt();

                    switch (listChoice) {

                        case 1:
                            runProgram(
                                    "dsapracticetracker.LinkedListOperations");
                            break;

                        case 2:
                            runProgram(
                                    "dsapracticetracker.DoublyLinkedList");
                            break;

                        case 3:
                            runProgram(
                                    "dsapracticetracker.CircularLinkedList");
                            break;

                        case 4:
                            runProgram(
                                    "dsapracticetracker.StackUsingLinkedList");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }

                    break;

                case 7:

                    System.out.println();
                    System.out.println("Tree:");
                    System.out.println("1. Binary Tree");
                    System.out.println("2. Binary Search Tree");

                    System.out.print("Enter choice: ");
                    int treeChoice = sc.nextInt();

                    if (treeChoice == 1) {

                        runProgram(
                                "dsapracticetracker.BinaryTree");

                    } else if (treeChoice == 2) {

                        runProgram(
                                "dsapracticetracker.BinarySearchTree");

                    } else {

                        System.out.println("Invalid choice.");
                    }

                    break;

                case 8:

                    runProgram(
                            "dsapracticetracker.Graph");

                    break;

                case 9:

                    System.out.println("Returning to main menu.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);
    }


    // =========================================================
    // RUN DSA PROGRAM
    // =========================================================
    static void runProgram(String className) {

        try {

            String javaPath =
                    System.getProperty("java.home")
                    + File.separator
                    + "bin"
                    + File.separator
                    + "java";

            String classPath =
                    System.getProperty("java.class.path");

            ProcessBuilder processBuilder =
                    new ProcessBuilder(
                            javaPath,
                            "-cp",
                            classPath,
                            className);

            processBuilder.inheritIO();

            Process process = processBuilder.start();

            process.waitFor();

            System.out.println();
            System.out.println("Returned to DSA menu.");

        } catch (Exception e) {

            System.out.println(
                    "Unable to run DSA program.");

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }


    // =========================================================
    // DISPLAY ONE PROBLEM
    // =========================================================
    static void displayProblem(Problem p) {

        System.out.println();
        System.out.println("-----------------------------------------");

        System.out.println("ID         : " + p.id);
        System.out.println("Problem    : " + p.name);
        System.out.println("Topic      : " + p.topic);
        System.out.println("Difficulty : " + p.difficulty);

        if (p.solved) {

            System.out.println("Status     : Solved");

        } else {

            System.out.println("Status     : Not Solved");
        }

        System.out.println("-----------------------------------------");
    }


    // =========================================================
    // SAVE PROBLEMS
    // =========================================================
    static void saveProblems(ArrayList<Problem> problems) {

        try {

            FileOutputStream fos =
                    new FileOutputStream(FILE_NAME);

            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            oos.writeObject(problems);

            oos.close();
            fos.close();

            System.out.println(
                    "Problems saved successfully!");

        } catch (Exception e) {

            System.out.println(
                    "Error while saving problems.");
        }
    }


    // =========================================================
    // LOAD PROBLEMS
    // =========================================================
    @SuppressWarnings("unchecked")
    static ArrayList<Problem> loadProblems() {

        try {

            FileInputStream fis =
                    new FileInputStream(FILE_NAME);

            ObjectInputStream ois =
                    new ObjectInputStream(fis);

            ArrayList<Problem> problems =
                    (ArrayList<Problem>) ois.readObject();

            ois.close();
            fis.close();

            return problems;

        } catch (Exception e) {

            // First run: no file exists
            return new ArrayList<>();
        }
    }
}