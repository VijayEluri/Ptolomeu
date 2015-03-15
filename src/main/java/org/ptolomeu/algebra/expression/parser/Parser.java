package org.ptolomeu.algebra.expression.parser;

import org.ptolomeu.util.Stack;

import java.util.logging.Logger;

public class Parser {

    private static Logger LOG = Logger.getLogger(Parser.class.getName());

    final ParserTable parserTable = ParserTable.newInstance();

    final Stack<Symbol> parserStack = Stack.newInstance();

    public Integer parse(String input) {
        parserStack.push(Symbol.TS_EOF);
        parserStack.push(Symbol.NTS_ADD);

        final Sentence sentence = Sentence.newInstance(input);
        final Tokens tokens = sentence.tokenizer();

        return doParse(sentence, tokens, new ExpressionTreeBuilder());
    }

    private Integer doParse(Sentence sentence, Tokens tokens, ExpressionTreeBuilder treeBuilder) {
        if (parserStack.peek() == Symbol.TS_EOF) {
            parserStack.pop(); // TODO RF Is this necessary?
            LOG.info("Yesss!! Bananas!");
            return treeBuilder.build().evaluate();
        }

        if (parserStack.peek() == tokens.current()) {
            treeBuilder.add(parserStack.pop());
            tokens.moveToNext();
            return doParse(sentence, tokens, treeBuilder);
        }

        try {
            parserTable.actionToTake(tokens.current(), parserStack.peek()).derive(parserStack);
            return doParse(sentence, tokens, treeBuilder);

        } catch (IllegalStateException e) {
            LOG.info("error while parsing the sencence " + sentence + ": " + e.getMessage());
            return -1; // horrible... bleeeeerrrgh. It will disappear in a few commits
        }

    }
}