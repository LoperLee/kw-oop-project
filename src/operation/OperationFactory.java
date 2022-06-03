package operation;

import operation.impl.Division;
import operation.impl.Multiplication;
import operation.impl.Plus;
import operation.impl.Subtract;

// Operation 구현체를 선택해서 제공해주는 클래스
public class OperationFactory {
    // Operation 구현체를 command를 통해서 적절한 구현체를 생성하여 제공하낟.
    public static Operation getOperation(String command) {
        Operation object;
        switch(command) {
            case "+":
                object = new Plus();
                break;
            case "-":
                object = new Subtract();
                break;
            case "/":
                object = new Division();
                break;
            case "*":
                object = new Multiplication();
                break;
            default:
                throw new ProviderException("제공하지 않는 계산 방식입니다.");
        }
        return object;
    }
}
