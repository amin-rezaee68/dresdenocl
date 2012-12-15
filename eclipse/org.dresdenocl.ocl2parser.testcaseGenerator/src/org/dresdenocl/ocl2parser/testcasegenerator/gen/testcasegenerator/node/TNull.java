/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TNull extends Token
{
    public TNull()
    {
        super.setText("null");
    }

    public TNull(int line, int pos)
    {
        super.setText("null");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TNull(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTNull(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTNull(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TNull text.");
    }
}