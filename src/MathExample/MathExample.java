package MathExample;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

import java.util.ArrayList;

public class MathExample {
    public MathExample(){}

    public Double Calculate(String example) throws UnparsableExpressionException, UnknownFunctionException {
       Calculable expression = new ExpressionBuilder(example).build();
        return expression.calculate();
    }

    public ArrayList<Double> Calculate(ArrayList<String> exampleList) throws UnparsableExpressionException, UnknownFunctionException {
        ArrayList<Double> resultList = new ArrayList<>();
        for(int i = 0; i < exampleList.size(); i++) {
            Calculable expression = new ExpressionBuilder(exampleList.get(i)).build();
            resultList.add(expression.calculate());
        }
        return resultList;
    }
}
