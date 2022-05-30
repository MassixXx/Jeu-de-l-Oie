package Kernel;

import Kernel.*;
import Kernel.Cases.*;

public abstract class C_Question extends Case {
    private static QuestionGen question_gen;

    abstract protected void generate_question();

    abstract protected void showPopWindow();
}
