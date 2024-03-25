import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redo;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redo = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        redo.clear();
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        redo.clear();
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            IMemento currentState = model.createMemento(); // redo memento added to redo list
            redo.add(currentState);
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    public void redo(){
        if(!redo.isEmpty()){
            IMemento currentState = model.createMemento(); // undo memento added to history
            history.add(currentState);
            System.out.println("Memento found in redo list");
            IMemento forwardState = redo.remove(redo.size() -1);
            model.restoreState(forwardState);
            gui.updateGui();
        }
    }
}
