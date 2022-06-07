package operation;

// 모든 계산기 작동의 기능을 일반화 해놓은 인터페이스
public interface Operation {
    // 실질적인 계산 작동 메소드
    public double doOperation(double a, double b);

    // 현재 상태를 가져오는 메소드
    String getStatus();
}
