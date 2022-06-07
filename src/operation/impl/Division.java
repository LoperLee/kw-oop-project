package operation.impl;

import history.History;
import operation.Operation;
import util.Util;

// 나눗셈을 담당하는 Operation 인터페이스의 구현체
public class Division implements Operation {
    private final static String STATUS_MESSAGE = "나누기를 수행할 숫자를 입력하세요.";
    private final History history;

    public Division(History history) {
        this.history = history;
    }

    @Override
    public double doOperation(double a, double b) {
        // TODO Auto-generated method stub
        double result = a / b;
        String log = a + " / " + b + " = " + Util.convertNumberToString(result);
        System.out.println(log);
        history.addHistory(log);
        return result;
    }

    @Override
    public String getStatus() {
        // TODO Auto-generated method stub
        return STATUS_MESSAGE;
    }

}
