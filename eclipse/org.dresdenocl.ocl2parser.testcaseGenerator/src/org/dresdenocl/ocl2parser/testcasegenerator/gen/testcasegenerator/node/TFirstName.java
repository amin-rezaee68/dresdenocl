/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TFirstName extends Token
{
    public TFirstName()
    {
        super.setText("model");
    }

    public TFirstName(int line, int pos)
    {
        super.setText("model");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TFirstName(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTFirstName(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTFirstName(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TFirstName text.");
    }
}