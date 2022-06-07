package operation;

import history.History;
import operation.impl.Division;
import operation.impl.Multiplication;
import operation.impl.Plus;
import operation.impl.Subtract;

// Operation 구현체를 선택해서 제공해주는 클래스
public class OperationFactory {
    // Operation 구현체를 command를 통해서 적절한 구현체를 생성하여 제공하낟.
    public static Operation getOperation(String command, History history) {
        Operation object;
        switch(command) {
            // + 경우 Plus 객체를 생성해서 전달
            case "+":
                object = new Plus(history);
                break;
            // - 경우 Subtract 객체를 생성해서 전달
            case "-":
                object = new Subtract(history);
                break;
            // / 경우 Division 객체를 생성해서 전달
            case "/":
                object = new Division(history);
                break;
            // +*경우 Multiplication 객체를 생성해서 전달
            case "*":
                object = new Multiplication(history);
                break;
            // 그 외의 연산자가 들어올 경우엔 에러!
            default:
                throw new ProviderException("제공하지 않는 계산 방식입니다.");
        }
        // 생성한 연산자를 전달+
        return object;
    }
}
