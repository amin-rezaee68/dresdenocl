/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TTLet extends Token
{
    public TTLet()
    {
        super.setText("let");
    }

    public TTLet(int line, int pos)
    {
        super.setText("let");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TTLet(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTLet(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TTLet text.");
    }
}

