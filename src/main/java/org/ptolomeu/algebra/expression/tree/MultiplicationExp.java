package org.ptolomeu.algebra.expression.tree;

public class MultiplicationExp extends AbstractNode {

    public MultiplicationExp() {
    }
    
    // TODO RF Is this constructor going to be used apart from testing code?
    public MultiplicationExp(AbstractNode left, AbstractNode right) {
        super(left, right);
    }

    @Override
    public Integer evaluate() {
        return left().evaluate() * right().evaluate();
    }

}
