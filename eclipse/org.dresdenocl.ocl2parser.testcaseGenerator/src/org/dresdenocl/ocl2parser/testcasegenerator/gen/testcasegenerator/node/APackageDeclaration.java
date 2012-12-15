/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import java.util.*;
import org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class APackageDeclaration extends PPackageDeclaration
{
    private TPackage _package_;
    private TPackageName _packageName_;

    public APackageDeclaration()
    {
    }

    public APackageDeclaration(
        TPackage _package_,
        TPackageName _packageName_)
    {
        setPackage(_package_);

        setPackageName(_packageName_);

    }
    public Object clone()
    {
        return new APackageDeclaration(
            (TPackage) cloneNode(_package_),
            (TPackageName) cloneNode(_packageName_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAPackageDeclaration(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseAPackageDeclaration(this, param);
    }

    public TPackage getPackage()
    {
        return _package_;
    }

    public void setPackage(TPackage node)
    {
        if(_package_ != null)
        {
            _package_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _package_ = node;
    }

    public TPackageName getPackageName()
    {
        return _packageName_;
    }

    public void setPackageName(TPackageName node)
    {
        if(_packageName_ != null)
        {
            _packageName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _packageName_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_package_)
            + toString(_packageName_);
    }

    void removeChild(Node child)
    {
        if(_package_ == child)
        {
            _package_ = null;
            return;
        }

        if(_packageName_ == child)
        {
            _packageName_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_package_ == oldChild)
        {
            setPackage((TPackage) newChild);
            return;
        }

        if(_packageName_ == oldChild)
        {
            setPackageName((TPackageName) newChild);
            return;
        }

    }
}