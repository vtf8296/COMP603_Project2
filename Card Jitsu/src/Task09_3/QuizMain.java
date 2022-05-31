
package Task09_3;


public class QuizMain {
    /**
     * Preparation:
     * Create Controller, Model, View, Database and Data class first.
     * The View class should extend JFrame and implement Observer.
     * The Model class should extend Observable.
     * The Controller should implement ActionListener.
     * 
     * Go to View.java for Step 1.
     */
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view); // Build connection between the view and the model.
    }
}
