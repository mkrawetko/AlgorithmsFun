package com.mkrawetko.support;

public class TestInput<I, O> {
    public final I input;
    public final O expected;

    public TestInput(I input, O expected) {
        this.input = input;
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "TestInput{" +
                "input=" + input +
                ", expected=" + expected +
                '}';
    }
}
