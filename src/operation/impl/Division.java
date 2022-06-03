package operation.impl;

import operation.Operation;

// 나눗셈을 담당하는 Operation 인터페이스의 구현체
public class Division implements Operation {

    @Override
    public int doOperation(int a, int b) {
        // TODO Auto-generated method stub
        return a / b;
    }

}
