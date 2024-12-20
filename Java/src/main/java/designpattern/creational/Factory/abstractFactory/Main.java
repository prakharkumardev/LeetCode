package designpattern.creational.Factory.abstractFactory;


interface Button {
    void render();
}

class BlackButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Black Button");
    }
}

class WhiteButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering White Button");
    }
}

interface ButtonFactory {
    Button createButton(String type);
}

class ConcreteButtonFactory implements ButtonFactory {
    @Override
    public Button createButton(String type) {
        switch (type.toLowerCase()) {
            case "black":
                return new BlackButton();
            case "white":
                return new WhiteButton();
            default:
                throw new IllegalArgumentException("Unknown button type: " + type);
        }
    }
}

interface Switch {
    void render();
}

class HorizontalSwitch implements Switch {
    @Override
    public void render() {
        System.out.println("Rendering Horizontal Switch");
    }
}

class VerticalSwitch implements Switch {
    @Override
    public void render() {
        System.out.println("Rendering Vertical Switch");
    }
}

interface SwitchFactory {
    Switch createSwitch(String type);
}

class ConcreteSwitchFactory implements SwitchFactory {
    @Override
    public Switch createSwitch(String type) {
        switch (type.toLowerCase()) {
            case "horizontal":
                return new HorizontalSwitch();
            case "vertical":
                return new VerticalSwitch();
            default:
                throw new IllegalArgumentException("Unknown switch type: " + type);
        }
    }
}

interface Checkbox {
    void render();
}

class RoundCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Round Checkbox");
    }
}

class SquareCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Square Checkbox");
    }
}

interface CheckboxFactory {
    Checkbox createCheckbox(String type);
}

class ConcreteCheckboxFactory implements CheckboxFactory {
    @Override
    public Checkbox createCheckbox(String type) {
        switch (type.toLowerCase()) {
            case "round":
                return new RoundCheckbox();
            case "square":
                return new SquareCheckbox();
            default:
                throw new IllegalArgumentException("Unknown checkbox type: " + type);
        }
    }
}

interface InputBox {
    void render();
}

class SingleLineInputBox implements InputBox {
    @Override
    public void render() {
        System.out.println("Rendering Single Line Input Box");
    }
}

class MultiLineInputBox implements InputBox {
    @Override
    public void render() {
        System.out.println("Rendering Multi Line Input Box");
    }
}

interface InputBoxFactory {
    InputBox createInputBox(String type);
}

class ConcreteInputBoxFactory implements InputBoxFactory {
    @Override
    public InputBox createInputBox(String type) {
        switch (type.toLowerCase()) {
            case "singleline":
                return new SingleLineInputBox();
            case "multiline":
                return new MultiLineInputBox();
            default:
                throw new IllegalArgumentException("Unknown input box type: " + type);
        }
    }
}

interface UnderInputFactory {
    ButtonFactory getButtonFactory();
    SwitchFactory getSwitchFactory();
    CheckboxFactory getCheckboxFactory();
    InputBoxFactory getInputBoxFactory();
}

class ConcreteUnderInputFactory implements UnderInputFactory {
    @Override
    public ButtonFactory getButtonFactory() {
        return new ConcreteButtonFactory();
    }

    @Override
    public SwitchFactory getSwitchFactory() {
        return new ConcreteSwitchFactory();
    }

    @Override
    public CheckboxFactory getCheckboxFactory() {
        return new ConcreteCheckboxFactory();
    }

    @Override
    public InputBoxFactory getInputBoxFactory() {
        return new ConcreteInputBoxFactory();
    }
}

/*
This scenario involves creating an Abstract Factory (UnderInputFactory) that produces
different factories for each UI component (ButtonFactory, SwitchFactory, CheckboxFactory,
InputBoxFactory). Each specific factory is responsible for creating the appropriate type
of its component (e.g., BlackButton, WhiteButton, etc.).

 */

public class Main {
    public static void main(String[] args) {
        // Create an instance of the UnderInputFactory
        UnderInputFactory factory = new ConcreteUnderInputFactory();

        // Get the factories
        ButtonFactory buttonFactory = factory.getButtonFactory();
        SwitchFactory switchFactory = factory.getSwitchFactory();
        CheckboxFactory checkboxFactory = factory.getCheckboxFactory();
        InputBoxFactory inputBoxFactory = factory.getInputBoxFactory();

        // Create and render components
        Button blackButton = buttonFactory.createButton("black");
        blackButton.render();

        Switch horizontalSwitch = switchFactory.createSwitch("horizontal");
        horizontalSwitch.render();

        Checkbox roundCheckbox = checkboxFactory.createCheckbox("round");
        roundCheckbox.render();

        InputBox singleLineInputBox = inputBoxFactory.createInputBox("singleline");
        singleLineInputBox.render();
    }
}
