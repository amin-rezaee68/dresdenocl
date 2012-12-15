/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TModel extends Token
{
    public TModel()
    {
        super.setText("#model");
    }

    public TModel(int line, int pos)
    {
        super.setText("#model");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TModel(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTModel(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTModel(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TModel text.");
    }
}