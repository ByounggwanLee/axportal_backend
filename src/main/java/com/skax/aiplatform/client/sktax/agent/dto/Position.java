package com.skax.aiplatform.client.sktax.agent.dto;

/**
 * SKTAX Agent Position Enum
 * 
 * <p>OpenAPI 스키마명: Position</p>
 * <p>노드의 위치를 나타내는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum Position {
    LEFT("left"),
    TOP("top"),
    RIGHT("right"),
    BOTTOM("bottom");

    private final String value;

    Position(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
