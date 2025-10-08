package de.JSONConverterSwing.florian;

public class BlogIdeaPrompt {
    public static class Task {
        String task1;
        String task2;
        String task3;
        // Klasseninterner Konstruktor
        public Task(String task1, String task2, String task3) {
            this.task1 = task1;
            this.task2 = task2;
            this.task3 = task3;
        }
        //Getter und Setter setzen
        public String getTask1() {
            return task1;
        }
        public void setTask1(String task1) {
            this.task1 = task1;
        }
        public String getTask2() {
            return task2;
        }
        public void setTask2(String task2) {
            this.task2 = task2;
        }
        public String getTask3() {
            return task3;
        }
    }
    Task tasks;
    String topic;
    String targetAudience;
    int quantity;
    String outputFormat;

    // Constructor
    public BlogIdeaPrompt(String task1, String task2, String task3, String topic, String targetAudience, int quantity, String outputFormat) {
        this.tasks = new Task(task1, task2, task3);
        this.topic = topic;
        this.targetAudience = targetAudience;
        this.quantity = quantity;
        this.outputFormat = outputFormat;
    }
    // Getter und Setter
    public Task getTask() {
        return tasks;
    }
    public void setTask(Task newTask) {
        this.tasks = newTask;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getTargetAudience() {
        return targetAudience;
    }
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }
}
