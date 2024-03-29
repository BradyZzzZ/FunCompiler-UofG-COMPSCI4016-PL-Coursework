//////////////////////////////////////////////////////////////
//
// A visitor for code generation for Fun.
//
// Based on a previous version developed by
// David Watt and Simon Gay (University of Glasgow).
//
// Modified for PL Coursework Assignment
// Name: Bin Zhang
// Student ID: 2941833z
// Date: 14th May 2024
//
//////////////////////////////////////////////////////////////

package fun;

import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.List;

import ast.*;

public class FunEncoderVisitor extends AbstractParseTreeVisitor<Void> implements FunVisitor<Void> {

	private SVM obj = new SVM();

	private int globalvaraddr = 0;
	private int localvaraddr = 0;
	private int currentLocale = Address.GLOBAL;

	private SymbolTable<Address> addrTable =
	   new SymbolTable<Address>();

	// EXTENSION: Extension B 
	List<Integer> caseJumpAddresses;
	FunParser.SwitchContext ctxcpy;
	//END OF EXTENSION

	private void predefine () {
	// Add predefined procedures to the address table.
		addrTable.put("read",
		   new Address(SVM.READOFFSET, Address.CODE));
		addrTable.put("write",
		   new Address(SVM.WRITEOFFSET, Address.CODE));
	}

	public SVM getSVM() {
	    return obj;
	}

	/**
	 * Visit a parse tree produced by the {@code prog}
	 * labeled alternative in {@link FunParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitProg(FunParser.ProgContext ctx) {
	    predefine();
	    List<FunParser.Var_declContext> var_decl = ctx.var_decl();
	    for (FunParser.Var_declContext vd : var_decl)
		visit(vd);
	    int calladdr = obj.currentOffset();
	    obj.emit12(SVM.CALL, 0);
	    obj.emit1(SVM.HALT);
	    List<FunParser.Proc_declContext> proc_decl = ctx.proc_decl();
	    for (FunParser.Proc_declContext pd : proc_decl)
		visit(pd);
	    int mainaddr = addrTable.get("main").offset;
	    obj.patch12(calladdr, mainaddr);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code proc}
	 * labeled alternative in {@link FunParser#proc_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitProc(FunParser.ProcContext ctx) {
	    String id = ctx.ID().getText();
	    Address procaddr = new Address(obj.currentOffset(), Address.CODE);
	    addrTable.put(id, procaddr);
	    addrTable.enterLocalScope();
	    currentLocale = Address.LOCAL;
	    localvaraddr = 2;
	    // ... allows 2 words for link data

		// ## Warm-up
		// Replace the type and method
	    FunParser.Formal_decl_seqContext fd = ctx.formal_decl_seq();

	    if (fd != null)
		visit(fd);
	    List<FunParser.Var_declContext> var_decl = ctx.var_decl();
	    for (FunParser.Var_declContext vd : var_decl)
		visit(vd);
	    visit(ctx.seq_com());
	    obj.emit11(SVM.RETURN, 0);
	    addrTable.exitLocalScope();
	    currentLocale = Address.GLOBAL;
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code func}
	 * labeled alternative in {@link FunParser#proc_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitFunc(FunParser.FuncContext ctx) {
	    String id = ctx.ID().getText();
	    Address procaddr = new Address(obj.currentOffset(), Address.CODE);
	    addrTable.put(id, procaddr);
	    addrTable.enterLocalScope();
	    currentLocale = Address.LOCAL;
	    localvaraddr = 2;
	    // ... allows 2 words for link data

	    // ## Warm-up
		// Replace the type and method
	    FunParser.Formal_decl_seqContext fd = ctx.formal_decl_seq();

	    if (fd != null)
		visit(fd);
	    List<FunParser.Var_declContext> var_decl = ctx.var_decl();
	    for (FunParser.Var_declContext vd : var_decl)
		visit(vd);
	    visit(ctx.seq_com());
            visit(ctx.expr());
	    obj.emit11(SVM.RETURN, 1);
	    addrTable.exitLocalScope();
	    currentLocale = Address.GLOBAL;
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code formal}
	 * labeled alternative in {@link FunParser#formal_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitFormal(FunParser.FormalContext ctx) {
		// ## Warm-up
		// Simplify the method visitFormal()
	    String id = ctx.ID().getText();
    	addrTable.put(id, new Address(localvaraddr++, Address.LOCAL));
    	obj.emit11(SVM.COPYARG, 1);
    	return null;
	}

	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link FunParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitVar(FunParser.VarContext ctx) {
	    visit(ctx.expr());
	    String id = ctx.ID().getText();
	    switch (currentLocale) {
	    case Address.LOCAL:
		addrTable.put(id, new Address(
					      localvaraddr++, Address.LOCAL));
		break;
	    case Address.GLOBAL:
		addrTable.put(id, new Address(
					      globalvaraddr++, Address.GLOBAL));
	    }
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FunParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitBool(FunParser.BoolContext ctx) {
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FunParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitInt(FunParser.IntContext ctx) {
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code assn}
	 * labeled alternative in {@link FunParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitAssn(FunParser.AssnContext ctx) {
	    visit(ctx.expr());
	    String id = ctx.ID().getText();
	    Address varaddr = addrTable.get(id);
	    switch (varaddr.locale) {
	    case Address.GLOBAL:
		obj.emit12(SVM.STOREG,varaddr.offset);
		break;
	    case Address.LOCAL:
		obj.emit12(SVM.STOREL,varaddr.offset);
	    }
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code proccall}
	 * labeled alternative in {@link FunParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitProccall(FunParser.ProccallContext ctx) {
		// ## Warm-up
		// Check if ctx.actual_seq() return null
	    if (ctx.actual_seq() != null) {
			visit(ctx.actual_seq());
		}

	    String id = ctx.ID().getText();
	    Address procaddr = addrTable.get(id);
	    // Assume procaddr.locale == CODE.
	    obj.emit12(SVM.CALL,procaddr.offset);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link FunParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitIf(FunParser.IfContext ctx) {
	    visit(ctx.expr());
	    int condaddr = obj.currentOffset();
	    obj.emit12(SVM.JUMPF, 0);
	    if (ctx.c2 == null) { // IF without ELSE
		visit(ctx.c1);
		int exitaddr = obj.currentOffset();
		obj.patch12(condaddr, exitaddr);
	    }
	    else {                // IF ... ELSE
		visit(ctx.c1);
		int jumpaddr = obj.currentOffset();
		obj.emit12(SVM.JUMP, 0);
		int elseaddr = obj.currentOffset();
		obj.patch12(condaddr, elseaddr);
		visit(ctx.c2);
		int exitaddr = obj.currentOffset();
		obj.patch12(jumpaddr, exitaddr);
	    }
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link FunParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitWhile(FunParser.WhileContext ctx) {
	    int startaddr = obj.currentOffset();
	    visit(ctx.expr());
	    int condaddr = obj.currentOffset();
	    obj.emit12(SVM.JUMPF, 0);
	    visit(ctx.seq_com());
	    obj.emit12(SVM.JUMP, startaddr);
	    int exitaddr = obj.currentOffset();
	    obj.patch12(condaddr, exitaddr);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link FunParser#seq_com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitSeq(FunParser.SeqContext ctx) {
	    visitChildren(ctx);
	    return null;
	}

	/**
	 * Visit a parse tree produced by {@link FunParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitExpr(FunParser.ExprContext ctx) {
	    visit(ctx.e1);
	    if (ctx.e2 != null) {
		visit(ctx.e2);
		switch (ctx.op.getType()) {
		case FunParser.EQ:
		    obj.emit1(SVM.CMPEQ);
		    break;
		case FunParser.LT:
		    obj.emit1(SVM.CMPLT);
		    break;
		case FunParser.GT:
		    obj.emit1(SVM.CMPGT);
		    break;
		}
	    }
	    return null;
	}

	/**
	 * Visit a parse tree produced by {@link FunParser#sec_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitSec_expr(FunParser.Sec_exprContext ctx) {
	    visit(ctx.e1);
	    if (ctx.e2 != null) {
		visit(ctx.e2);
		switch (ctx.op.getType()) {
		case FunParser.PLUS:
		    obj.emit1(SVM.ADD);
		    break;
		case FunParser.MINUS:
		    obj.emit1(SVM.SUB);
		    break;
		case FunParser.TIMES:
		    obj.emit1(SVM.MUL);
		    break;
		case FunParser.DIV:
		    obj.emit1(SVM.DIV);
		    break;
		}
	    }
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitFalse(FunParser.FalseContext ctx) {
	    obj.emit12(SVM.LOADC, 0);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitTrue(FunParser.TrueContext ctx) {
	    obj.emit12(SVM.LOADC, 1);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitNum(FunParser.NumContext ctx) {
	    int value = Integer.parseInt(ctx.NUM().getText());
	    obj.emit12(SVM.LOADC, value);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitId(FunParser.IdContext ctx) {
	    String id = ctx.ID().getText();
	    Address varaddr = addrTable.get(id);
	    switch (varaddr.locale) {
	    case Address.GLOBAL:
		obj.emit12(SVM.LOADG,varaddr.offset);
		break;
	    case Address.LOCAL:
		obj.emit12(SVM.LOADL,varaddr.offset);
	    }
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code funccall}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitFunccall(FunParser.FunccallContext ctx) {
	    // ## Warm-up
		// Check if ctx.actual_seq() return null
	    if (ctx.actual_seq() != null) {
			visit(ctx.actual_seq());
		}

	    String id = ctx.ID().getText();
	    Address funcaddr = addrTable.get(id);
	    // Assume that funcaddr.locale == CODE.
	    obj.emit12(SVM.CALL,funcaddr.offset);
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitNot(FunParser.NotContext ctx) {
	    visit(ctx.prim_expr());
	    obj.emit1(SVM.INV); 
	    return null;
	}

	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FunParser#prim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	public Void visitParens(FunParser.ParensContext ctx) {
	    visit(ctx.expr());
	    return null;
	}

	/**
	 * Visit a parse tree produced by {@link FunParser#actual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */

	// ## Warm-up
	// Replace visitActual() by visitActualseq()
	public Void visitActualseq(FunParser.ActualseqContext ctx) {
	    for (FunParser.ExprContext expr : ctx.expr()) {
			visit(expr);
		}
	    return null;
	}

	// ## Warm-up
	// Add a method visitFormalseq()
	public Void visitFormalseq(FunParser.FormalseqContext ctx) {
		for (FunParser.Formal_declContext fdc : ctx.formal_decl()) {
			visit(fdc);
		}
		return null;
	}

	// EXTENSION: Extension A - Encoder of repeat-until command

	/* Code Template for repeat-until command:
	 *	  code to execute seq_com
	 *	  code to evaluate expr
	 *	  JUMPF
	*/ 

	public Void visitRepeat(FunParser.RepeatContext ctx) {
		int startLoopAddr = obj.currentOffset(); // Mark the start of the loop
		
		// Generate code for the sequence of commands in the loop
		visit(ctx.seq_com()); 
		
		// Generate code to evaluate the condition
		visit(ctx.expr()); 
		
		// Emit a conditional jump back to the start if the condition is false
		obj.emit12(SVM.JUMPF, startLoopAddr); 
		
		return null; 
	}

	// END OF EXTENSION


	// EXTENSION: Extension B - Encoder of switch command

	/* Code Template for repeat-until command:
	 *	    code to evaluate expr
	 *   case:
	 * 	    COMPEQ (or COMPLT, COMPGT for range case)
	 *      JUMPF  (or JUMPT for range case)
	 *	    code to execute seq_com
	 *	    JUMP
	 *   default case:
	 *	    code to execute seq_com
	*/ 

	public Void visitSwitch(FunParser.SwitchContext ctx) {

		// Copy the instance
		ctxcpy = ctx;

    	// Update the ArrarList for storing the address of each case's JUMP instruction
    	caseJumpAddresses = new ArrayList<>();

		// Gengrate code for all cases
		visitCaseseq((FunParser.CaseseqContext)ctx.case_seq());

		// Gengrate code for default case
    	visitDefaultcase((FunParser.DefaultcaseContext)ctx.default_case());

		// Get the address of the end of switch command
		int switchEndAddr = obj.currentOffset();

    	// Backfill the jump address of all cases to the end of the switch position
    	for (Integer addr : caseJumpAddresses) {
        	obj.patch12(addr, switchEndAddr);
    	}

    	return null;
	}

	public Void visitCaseseq(FunParser.CaseseqContext ctx) {
		// Generate code for evaluating and jumping based on case conditions
		for (FunParser.Case_comContext caseCtx : ctx.case_com()) {
			visitCase((FunParser.CaseContext)caseCtx);
		}
		return null;
	}

	public Void visitCase(FunParser.CaseContext ctx) {
		// Generate code to evaluate the condition
    	visit(ctxcpy.expr());

		// Check case for int, bool, range type
		if (ctx.NUM() != null) {
			int caseValue = Integer.parseInt(ctx.NUM().getText());
			obj.emit12(SVM.LOADC, caseValue); 
			obj.emit1(SVM.CMPEQ);
		} else if (ctx.TRUE() != null) {
			boolean caseValue = Boolean.parseBoolean(ctx.TRUE().getText());
			obj.emit12(SVM.LOADC, 1); 
			obj.emit1(SVM.CMPEQ);
		}else if (ctx.FALSE() != null) {
			boolean caseValue = Boolean.parseBoolean(ctx.FALSE().getText());
			obj.emit12(SVM.LOADC, 0); 
			obj.emit1(SVM.CMPEQ);
		}else if (ctx.range() != null) {
			// Deal with range
			FunParser.RangeofintContext ctxrange=(FunParser.RangeofintContext)ctx.range();

			// Get the start and end value
			int startValue = Integer.parseInt(ctxrange.NUM(0).getText());
			int endValue = Integer.parseInt(ctxrange.NUM(1).getText());

			// Check if less than start value
			obj.emit12(SVM.LOADC, startValue); 
			obj.emit1(SVM.CMPLT); 
			int jumpIfLessStart = obj.currentOffset();
			obj.emit12(SVM.JUMPT, 0); 

			// 注意：不要漏掉这个，否则会导致运行出错，因为这里涉及两次比较 ！！
			visit(ctxcpy.expr());
	
			// Check if great than end value
			obj.emit12(SVM.LOADC, endValue); 
			obj.emit1(SVM.CMPGT); 
			int jumpIfGreaterEnd = obj.currentOffset();
			obj.emit12(SVM.JUMPT, 0); 

			// Visit and generate code
			visit(ctx.seq_com());

			// For jumping to the end of switch after running the matched case
			int skipToEndJumpAddr = obj.currentOffset();
			obj.emit12(SVM.JUMP, 0); 

			caseJumpAddresses.add(skipToEndJumpAddr);

			// Backfill jump address for skipping case content
			int afterComparison = obj.currentOffset();
			obj.patch12(jumpIfLessStart, afterComparison);
			obj.patch12(jumpIfGreaterEnd, afterComparison);
		}
	
		// Deal with int and bool
		if (ctx.NUM() != null || ctx.TRUE() != null || ctx.FALSE() != null) {
			// Jump based on comparison results
			int jumpAddr = obj.currentOffset();
    		obj.emit12(SVM.JUMPF, 0);
	
			// Visit and generate code
			visit(ctx.seq_com());
	
			// For jumping to the end of switch after running the matched case
			int endJumpAddr = obj.currentOffset();
			obj.emit12(SVM.JUMP, 0); 
	
			caseJumpAddresses.add(endJumpAddr);
	
			// Backfill jump address for skipping case content
			int nextCaseAddr = obj.currentOffset();
    		obj.patch12(jumpAddr, nextCaseAddr);
		}
	
		return null;
	}

	// ** Note: Since we deal with range in visitCase() directly,
	// we don't need this method, so just return null for scccessfully compile
	public Void visitRangeofint(FunParser.RangeofintContext ctx) {
		return null;
	}

	public Void visitDefaultcase(FunParser.DefaultcaseContext ctx) {
		// Visit default case and generate code
		visit(ctx.seq_com());
		return null;
	}

	//END OF EXTENSION

}
