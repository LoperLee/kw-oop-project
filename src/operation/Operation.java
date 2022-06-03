package operation;

// 모든 계산기 작동의 기능을 일반화 해놓은 인터페이스
public interface Operation {
    // 실질적인 계산 작동 메소드
    int doOperation(int a, int b);
}
