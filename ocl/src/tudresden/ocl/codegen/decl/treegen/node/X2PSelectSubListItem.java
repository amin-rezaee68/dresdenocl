/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class X2PSelectSubListItem extends XPSelectSubListItem
{
    private PSelectSubListItem _pSelectSubListItem_;

    public X2PSelectSubListItem()
    {
    }

    public X2PSelectSubListItem(
        PSelectSubListItem _pSelectSubListItem_)
    {
        setPSelectSubListItem(_pSelectSubListItem_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PSelectSubListItem getPSelectSubListItem()
    {
        return _pSelectSubListItem_;
    }

    public void setPSelectSubListItem(PSelectSubListItem node)
    {
        if(_pSelectSubListItem_ != null)
        {
            _pSelectSubListItem_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pSelectSubListItem_ = node;
    }

    void removeChild(Node child)
    {
        if(_pSelectSubListItem_ == child)
        {
            _pSelectSubListItem_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pSelectSubListItem_);
    }
}