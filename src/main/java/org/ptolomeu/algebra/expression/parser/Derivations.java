package org.ptolomeu.algebra.expression.parser;

import org.ptolomeu.util.Stack;

import static org.ptolomeu.algebra.expression.parser.Symbol.*;

public enum Derivations implements Derivation {

    // Replacing Add...
    REPLACE_ADD_BY_INT_AND_ADD_2 {
        @Override
        public void derive(Stack<Symbol> parserStack) {
            parserStack.pop();
            parserStack.push(NTS_ADD_2);
            parserStack.push(NTS_INT);
        }
    },

    // Replacing Add'
    REPLACE_ADD_2_BY_PLUS_AND_INT_AND_ADD_2 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(NTS_ADD_2);
            stack.push(NTS_INT);
            stack.push(TS_PLUS);
        }
    },
    REPLACE_ADD_2_BY_EOF {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
        }
    },

    // Replacing Int by TS_*. It needs to keep the Symbol there so the parser table know what comes next
    REPLACE_INT_BY_0 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_0);
        }
    },
    REPLACE_INT_BY_1 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_1);
        }
    },
    REPLACE_INT_BY_2 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_2);
        }
    },
    REPLACE_INT_BY_3 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_3);
        }
    },
    REPLACE_INT_BY_4 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_4);
        }
    },
    REPLACE_INT_BY_5 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_5);
        }
    },
    REPLACE_INT_BY_6 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_6);
        }
    },
    REPLACE_INT_BY_7 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_7);
        }
    },
    REPLACE_INT_BY_8 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_8);
        }
    },
    REPLACE_INT_BY_9 {
        @Override
        public void derive(Stack<Symbol> stack) {
            stack.pop();
            stack.push(TS_9);
        }
    };
}