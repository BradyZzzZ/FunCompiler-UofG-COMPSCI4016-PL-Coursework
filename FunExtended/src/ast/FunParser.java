// Generated from src/ast/Fun.g4 by ANTLR 4.9.1

    package ast;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FunParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOL=1, ELSE=2, FALSE=3, FUNC=4, IF=5, INT=6, PROC=7, RETURN=8, TRUE=9, 
		WHILE=10, REPEAT=11, UNTIL=12, SWITCH=13, CASE=14, DEFAULT=15, EQ=16, 
		LT=17, GT=18, PLUS=19, MINUS=20, TIMES=21, DIV=22, NOT=23, ASSN=24, LPAR=25, 
		RPAR=26, COLON=27, DOT=28, COMMA=29, RANGE=30, NUM=31, ID=32, SPACE=33, 
		EOL=34, COMMENT=35;
	public static final int
		RULE_program = 0, RULE_proc_decl = 1, RULE_formal_decl_seq = 2, RULE_formal_decl = 3, 
		RULE_var_decl = 4, RULE_type = 5, RULE_com = 6, RULE_seq_com = 7, RULE_case_seq = 8, 
		RULE_case_com = 9, RULE_range = 10, RULE_default_case = 11, RULE_expr = 12, 
		RULE_sec_expr = 13, RULE_prim_expr = 14, RULE_actual_seq = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "proc_decl", "formal_decl_seq", "formal_decl", "var_decl", 
			"type", "com", "seq_com", "case_seq", "case_com", "range", "default_case", 
			"expr", "sec_expr", "prim_expr", "actual_seq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bool'", "'else'", "'false'", "'func'", "'if'", "'int'", "'proc'", 
			"'return'", "'true'", "'while'", "'repeat'", "'until'", "'switch'", "'case'", 
			"'default'", "'=='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'not'", 
			"'='", "'('", "')'", "':'", "'.'", "','", "'..'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOL", "ELSE", "FALSE", "FUNC", "IF", "INT", "PROC", "RETURN", 
			"TRUE", "WHILE", "REPEAT", "UNTIL", "SWITCH", "CASE", "DEFAULT", "EQ", 
			"LT", "GT", "PLUS", "MINUS", "TIMES", "DIV", "NOT", "ASSN", "LPAR", "RPAR", 
			"COLON", "DOT", "COMMA", "RANGE", "NUM", "ID", "SPACE", "EOL", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Fun.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FunParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgContext extends ProgramContext {
		public TerminalNode EOF() { return getToken(FunParser.EOF, 0); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<Proc_declContext> proc_decl() {
			return getRuleContexts(Proc_declContext.class);
		}
		public Proc_declContext proc_decl(int i) {
			return getRuleContext(Proc_declContext.class,i);
		}
		public ProgContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			_localctx = new ProgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BOOL || _la==INT) {
				{
				{
				setState(32);
				var_decl();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				proc_decl();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNC || _la==PROC );
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proc_declContext extends ParserRuleContext {
		public Proc_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proc_decl; }
	 
		public Proc_declContext() { }
		public void copyFrom(Proc_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProcContext extends Proc_declContext {
		public TerminalNode PROC() { return getToken(FunParser.PROC, 0); }
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FunParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(FunParser.COLON, 0); }
		public Seq_comContext seq_com() {
			return getRuleContext(Seq_comContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FunParser.DOT, 0); }
		public Formal_decl_seqContext formal_decl_seq() {
			return getRuleContext(Formal_decl_seqContext.class,0);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public ProcContext(Proc_declContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitProc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncContext extends Proc_declContext {
		public TerminalNode FUNC() { return getToken(FunParser.FUNC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FunParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(FunParser.COLON, 0); }
		public Seq_comContext seq_com() {
			return getRuleContext(Seq_comContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(FunParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FunParser.DOT, 0); }
		public Formal_decl_seqContext formal_decl_seq() {
			return getRuleContext(Formal_decl_seqContext.class,0);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public FuncContext(Proc_declContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proc_declContext proc_decl() throws RecognitionException {
		Proc_declContext _localctx = new Proc_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_proc_decl);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROC:
				_localctx = new ProcContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(PROC);
				setState(46);
				match(ID);
				setState(47);
				match(LPAR);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOL || _la==INT) {
					{
					setState(48);
					formal_decl_seq();
					}
				}

				setState(51);
				match(RPAR);
				setState(52);
				match(COLON);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BOOL || _la==INT) {
					{
					{
					setState(53);
					var_decl();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				seq_com();
				setState(60);
				match(DOT);
				}
				break;
			case FUNC:
				_localctx = new FuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(FUNC);
				setState(63);
				type();
				setState(64);
				match(ID);
				setState(65);
				match(LPAR);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOL || _la==INT) {
					{
					setState(66);
					formal_decl_seq();
					}
				}

				setState(69);
				match(RPAR);
				setState(70);
				match(COLON);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BOOL || _la==INT) {
					{
					{
					setState(71);
					var_decl();
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(77);
				seq_com();
				setState(78);
				match(RETURN);
				setState(79);
				expr();
				setState(80);
				match(DOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Formal_decl_seqContext extends ParserRuleContext {
		public Formal_decl_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_decl_seq; }
	 
		public Formal_decl_seqContext() { }
		public void copyFrom(Formal_decl_seqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormalseqContext extends Formal_decl_seqContext {
		public List<Formal_declContext> formal_decl() {
			return getRuleContexts(Formal_declContext.class);
		}
		public Formal_declContext formal_decl(int i) {
			return getRuleContext(Formal_declContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunParser.COMMA, i);
		}
		public FormalseqContext(Formal_decl_seqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitFormalseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_decl_seqContext formal_decl_seq() throws RecognitionException {
		Formal_decl_seqContext _localctx = new Formal_decl_seqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formal_decl_seq);
		int _la;
		try {
			_localctx = new FormalseqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			formal_decl();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(85);
				match(COMMA);
				setState(86);
				formal_decl();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Formal_declContext extends ParserRuleContext {
		public Formal_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_decl; }
	 
		public Formal_declContext() { }
		public void copyFrom(Formal_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormalContext extends Formal_declContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public FormalContext(Formal_declContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_declContext formal_decl() throws RecognitionException {
		Formal_declContext _localctx = new Formal_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal_decl);
		try {
			_localctx = new FormalContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			type();
			setState(93);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	 
		public Var_declContext() { }
		public void copyFrom(Var_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarContext extends Var_declContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public TerminalNode ASSN() { return getToken(FunParser.ASSN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarContext(Var_declContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var_decl);
		try {
			_localctx = new VarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			type();
			setState(96);
			match(ID);
			setState(97);
			match(ASSN);
			setState(98);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(FunParser.BOOL, 0); }
		public BoolContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends TypeContext {
		public TerminalNode INT() { return getToken(FunParser.INT, 0); }
		public IntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(BOOL);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssnContext extends ComContext {
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public TerminalNode ASSN() { return getToken(FunParser.ASSN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssnContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitAssn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProccallContext extends ComContext {
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FunParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunParser.RPAR, 0); }
		public Actual_seqContext actual_seq() {
			return getRuleContext(Actual_seqContext.class,0);
		}
		public ProccallContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitProccall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatContext extends ComContext {
		public TerminalNode REPEAT() { return getToken(FunParser.REPEAT, 0); }
		public TerminalNode COLON() { return getToken(FunParser.COLON, 0); }
		public Seq_comContext seq_com() {
			return getRuleContext(Seq_comContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(FunParser.UNTIL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FunParser.DOT, 0); }
		public RepeatContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitRepeat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends ComContext {
		public TerminalNode WHILE() { return getToken(FunParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(FunParser.COLON, 0); }
		public Seq_comContext seq_com() {
			return getRuleContext(Seq_comContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FunParser.DOT, 0); }
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends ComContext {
		public Seq_comContext c1;
		public Seq_comContext c2;
		public TerminalNode IF() { return getToken(FunParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(FunParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(FunParser.COLON, i);
		}
		public List<Seq_comContext> seq_com() {
			return getRuleContexts(Seq_comContext.class);
		}
		public Seq_comContext seq_com(int i) {
			return getRuleContext(Seq_comContext.class,i);
		}
		public TerminalNode DOT() { return getToken(FunParser.DOT, 0); }
		public TerminalNode ELSE() { return getToken(FunParser.ELSE, 0); }
		public IfContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwitchContext extends ComContext {
		public TerminalNode SWITCH() { return getToken(FunParser.SWITCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Case_seqContext case_seq() {
			return getRuleContext(Case_seqContext.class,0);
		}
		public Default_caseContext default_case() {
			return getRuleContext(Default_caseContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FunParser.DOT, 0); }
		public SwitchContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitSwitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		ComContext _localctx = new ComContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_com);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new AssnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(ID);
				setState(105);
				match(ASSN);
				setState(106);
				expr();
				}
				break;
			case 2:
				_localctx = new ProccallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(ID);
				setState(108);
				match(LPAR);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << TRUE) | (1L << NOT) | (1L << LPAR) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(109);
					actual_seq();
					}
				}

				setState(112);
				match(RPAR);
				}
				break;
			case 3:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(IF);
				setState(114);
				expr();
				setState(115);
				match(COLON);
				setState(116);
				((IfContext)_localctx).c1 = seq_com();
				setState(123);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(117);
					match(DOT);
					}
					break;
				case ELSE:
					{
					setState(118);
					match(ELSE);
					setState(119);
					match(COLON);
					setState(120);
					((IfContext)_localctx).c2 = seq_com();
					setState(121);
					match(DOT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				match(WHILE);
				setState(126);
				expr();
				setState(127);
				match(COLON);
				setState(128);
				seq_com();
				setState(129);
				match(DOT);
				}
				break;
			case 5:
				_localctx = new RepeatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(131);
				match(REPEAT);
				setState(132);
				match(COLON);
				setState(133);
				seq_com();
				setState(134);
				match(UNTIL);
				setState(135);
				expr();
				setState(136);
				match(DOT);
				}
				break;
			case 6:
				_localctx = new SwitchContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(138);
				match(SWITCH);
				setState(139);
				expr();
				setState(140);
				case_seq();
				setState(141);
				default_case();
				setState(142);
				match(DOT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Seq_comContext extends ParserRuleContext {
		public Seq_comContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq_com; }
	 
		public Seq_comContext() { }
		public void copyFrom(Seq_comContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SeqContext extends Seq_comContext {
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public SeqContext(Seq_comContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Seq_comContext seq_com() throws RecognitionException {
		Seq_comContext _localctx = new Seq_comContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_seq_com);
		int _la;
		try {
			_localctx = new SeqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << REPEAT) | (1L << SWITCH) | (1L << ID))) != 0)) {
				{
				{
				setState(146);
				com();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_seqContext extends ParserRuleContext {
		public Case_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_seq; }
	 
		public Case_seqContext() { }
		public void copyFrom(Case_seqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CaseseqContext extends Case_seqContext {
		public List<Case_comContext> case_com() {
			return getRuleContexts(Case_comContext.class);
		}
		public Case_comContext case_com(int i) {
			return getRuleContext(Case_comContext.class,i);
		}
		public CaseseqContext(Case_seqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitCaseseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_seqContext case_seq() throws RecognitionException {
		Case_seqContext _localctx = new Case_seqContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_case_seq);
		int _la;
		try {
			_localctx = new CaseseqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(152);
				case_com();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_comContext extends ParserRuleContext {
		public Case_comContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_com; }
	 
		public Case_comContext() { }
		public void copyFrom(Case_comContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CaseContext extends Case_comContext {
		public TerminalNode CASE() { return getToken(FunParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(FunParser.COLON, 0); }
		public Seq_comContext seq_com() {
			return getRuleContext(Seq_comContext.class,0);
		}
		public TerminalNode NUM() { return getToken(FunParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(FunParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FunParser.FALSE, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public CaseContext(Case_comContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_comContext case_com() throws RecognitionException {
		Case_comContext _localctx = new Case_comContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_case_com);
		try {
			_localctx = new CaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(CASE);
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(159);
				match(NUM);
				}
				break;
			case 2:
				{
				setState(160);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(161);
				match(FALSE);
				}
				break;
			case 4:
				{
				setState(162);
				range();
				}
				break;
			}
			setState(165);
			match(COLON);
			setState(166);
			seq_com();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
	 
		public RangeContext() { }
		public void copyFrom(RangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RangeofintContext extends RangeContext {
		public List<TerminalNode> NUM() { return getTokens(FunParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(FunParser.NUM, i);
		}
		public TerminalNode RANGE() { return getToken(FunParser.RANGE, 0); }
		public RangeofintContext(RangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitRangeofint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_range);
		try {
			_localctx = new RangeofintContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(NUM);
			setState(169);
			match(RANGE);
			setState(170);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_caseContext extends ParserRuleContext {
		public Default_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_case; }
	 
		public Default_caseContext() { }
		public void copyFrom(Default_caseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefaultcaseContext extends Default_caseContext {
		public TerminalNode DEFAULT() { return getToken(FunParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(FunParser.COLON, 0); }
		public Seq_comContext seq_com() {
			return getRuleContext(Seq_comContext.class,0);
		}
		public DefaultcaseContext(Default_caseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitDefaultcase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_caseContext default_case() throws RecognitionException {
		Default_caseContext _localctx = new Default_caseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_default_case);
		try {
			_localctx = new DefaultcaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(DEFAULT);
			setState(173);
			match(COLON);
			setState(174);
			seq_com();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Sec_exprContext e1;
		public Token op;
		public Sec_exprContext e2;
		public List<Sec_exprContext> sec_expr() {
			return getRuleContexts(Sec_exprContext.class);
		}
		public Sec_exprContext sec_expr(int i) {
			return getRuleContext(Sec_exprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FunParser.EQ, 0); }
		public TerminalNode LT() { return getToken(FunParser.LT, 0); }
		public TerminalNode GT() { return getToken(FunParser.GT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			((ExprContext)_localctx).e1 = sec_expr();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LT) | (1L << GT))) != 0)) {
				{
				setState(177);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LT) | (1L << GT))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(178);
				((ExprContext)_localctx).e2 = sec_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sec_exprContext extends ParserRuleContext {
		public Prim_exprContext e1;
		public Token op;
		public Sec_exprContext e2;
		public Prim_exprContext prim_expr() {
			return getRuleContext(Prim_exprContext.class,0);
		}
		public Sec_exprContext sec_expr() {
			return getRuleContext(Sec_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FunParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FunParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(FunParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(FunParser.DIV, 0); }
		public Sec_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sec_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitSec_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sec_exprContext sec_expr() throws RecognitionException {
		Sec_exprContext _localctx = new Sec_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sec_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			((Sec_exprContext)_localctx).e1 = prim_expr();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << DIV))) != 0)) {
				{
				setState(182);
				((Sec_exprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << DIV))) != 0)) ) {
					((Sec_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				((Sec_exprContext)_localctx).e2 = sec_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Prim_exprContext extends ParserRuleContext {
		public Prim_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim_expr; }
	 
		public Prim_exprContext() { }
		public void copyFrom(Prim_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends Prim_exprContext {
		public TerminalNode NOT() { return getToken(FunParser.NOT, 0); }
		public Prim_exprContext prim_expr() {
			return getRuleContext(Prim_exprContext.class,0);
		}
		public NotContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends Prim_exprContext {
		public TerminalNode LPAR() { return getToken(FunParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunParser.RPAR, 0); }
		public ParensContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunccallContext extends Prim_exprContext {
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FunParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunParser.RPAR, 0); }
		public Actual_seqContext actual_seq() {
			return getRuleContext(Actual_seqContext.class,0);
		}
		public FunccallContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends Prim_exprContext {
		public TerminalNode NUM() { return getToken(FunParser.NUM, 0); }
		public NumContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends Prim_exprContext {
		public TerminalNode FALSE() { return getToken(FunParser.FALSE, 0); }
		public FalseContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends Prim_exprContext {
		public TerminalNode TRUE() { return getToken(FunParser.TRUE, 0); }
		public TrueContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends Prim_exprContext {
		public TerminalNode ID() { return getToken(FunParser.ID, 0); }
		public IdContext(Prim_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prim_exprContext prim_expr() throws RecognitionException {
		Prim_exprContext _localctx = new Prim_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prim_expr);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(FALSE);
				}
				break;
			case 2:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(TRUE);
				}
				break;
			case 3:
				_localctx = new NumContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(NUM);
				}
				break;
			case 4:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(189);
				match(ID);
				}
				break;
			case 5:
				_localctx = new FunccallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(190);
				match(ID);
				setState(191);
				match(LPAR);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << TRUE) | (1L << NOT) | (1L << LPAR) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(192);
					actual_seq();
					}
				}

				setState(195);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(196);
				match(NOT);
				setState(197);
				prim_expr();
				}
				break;
			case 7:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(198);
				match(LPAR);
				setState(199);
				expr();
				setState(200);
				match(RPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Actual_seqContext extends ParserRuleContext {
		public Actual_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actual_seq; }
	 
		public Actual_seqContext() { }
		public void copyFrom(Actual_seqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ActualseqContext extends Actual_seqContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunParser.COMMA, i);
		}
		public ActualseqContext(Actual_seqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunVisitor ) return ((FunVisitor<? extends T>)visitor).visitActualseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Actual_seqContext actual_seq() throws RecognitionException {
		Actual_seqContext _localctx = new Actual_seqContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_actual_seq);
		int _la;
		try {
			_localctx = new ActualseqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			expr();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(205);
				match(COMMA);
				setState(206);
				expr();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00d7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\6\2*\n\2\r\2\16\2+\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3F\n\3\3\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3U\n\3\3\4\3\4\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\5\7i\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bq\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b~\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0093\n\b\3\t\7"+
		"\t\u0096\n\t\f\t\16\t\u0099\13\t\3\n\7\n\u009c\n\n\f\n\16\n\u009f\13\n"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00a6\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00b6\n\16\3\17\3\17\3\17\5\17"+
		"\u00bb\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c4\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u00cd\n\20\3\21\3\21\3\21\7\21\u00d2"+
		"\n\21\f\21\16\21\u00d5\13\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\4\3\2\22\24\3\2\25\30\2\u00e5\2%\3\2\2\2\4T\3\2\2\2\6V\3"+
		"\2\2\2\b^\3\2\2\2\na\3\2\2\2\fh\3\2\2\2\16\u0092\3\2\2\2\20\u0097\3\2"+
		"\2\2\22\u009d\3\2\2\2\24\u00a0\3\2\2\2\26\u00aa\3\2\2\2\30\u00ae\3\2\2"+
		"\2\32\u00b2\3\2\2\2\34\u00b7\3\2\2\2\36\u00cc\3\2\2\2 \u00ce\3\2\2\2\""+
		"$\5\n\6\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&)\3\2\2\2\'%\3\2\2"+
		"\2(*\5\4\3\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\2\2"+
		"\3.\3\3\2\2\2/\60\7\t\2\2\60\61\7\"\2\2\61\63\7\33\2\2\62\64\5\6\4\2\63"+
		"\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\34\2\2\66:\7\35\2\2\67"+
		"9\5\n\6\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2"+
		"\2=>\5\20\t\2>?\7\36\2\2?U\3\2\2\2@A\7\6\2\2AB\5\f\7\2BC\7\"\2\2CE\7\33"+
		"\2\2DF\5\6\4\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\34\2\2HL\7\35\2\2IK\5"+
		"\n\6\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\5"+
		"\20\t\2PQ\7\n\2\2QR\5\32\16\2RS\7\36\2\2SU\3\2\2\2T/\3\2\2\2T@\3\2\2\2"+
		"U\5\3\2\2\2V[\5\b\5\2WX\7\37\2\2XZ\5\b\5\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2"+
		"\2[\\\3\2\2\2\\\7\3\2\2\2][\3\2\2\2^_\5\f\7\2_`\7\"\2\2`\t\3\2\2\2ab\5"+
		"\f\7\2bc\7\"\2\2cd\7\32\2\2de\5\32\16\2e\13\3\2\2\2fi\7\3\2\2gi\7\b\2"+
		"\2hf\3\2\2\2hg\3\2\2\2i\r\3\2\2\2jk\7\"\2\2kl\7\32\2\2l\u0093\5\32\16"+
		"\2mn\7\"\2\2np\7\33\2\2oq\5 \21\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2r\u0093"+
		"\7\34\2\2st\7\7\2\2tu\5\32\16\2uv\7\35\2\2v}\5\20\t\2w~\7\36\2\2xy\7\4"+
		"\2\2yz\7\35\2\2z{\5\20\t\2{|\7\36\2\2|~\3\2\2\2}w\3\2\2\2}x\3\2\2\2~\u0093"+
		"\3\2\2\2\177\u0080\7\f\2\2\u0080\u0081\5\32\16\2\u0081\u0082\7\35\2\2"+
		"\u0082\u0083\5\20\t\2\u0083\u0084\7\36\2\2\u0084\u0093\3\2\2\2\u0085\u0086"+
		"\7\r\2\2\u0086\u0087\7\35\2\2\u0087\u0088\5\20\t\2\u0088\u0089\7\16\2"+
		"\2\u0089\u008a\5\32\16\2\u008a\u008b\7\36\2\2\u008b\u0093\3\2\2\2\u008c"+
		"\u008d\7\17\2\2\u008d\u008e\5\32\16\2\u008e\u008f\5\22\n\2\u008f\u0090"+
		"\5\30\r\2\u0090\u0091\7\36\2\2\u0091\u0093\3\2\2\2\u0092j\3\2\2\2\u0092"+
		"m\3\2\2\2\u0092s\3\2\2\2\u0092\177\3\2\2\2\u0092\u0085\3\2\2\2\u0092\u008c"+
		"\3\2\2\2\u0093\17\3\2\2\2\u0094\u0096\5\16\b\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\21\3\2\2"+
		"\2\u0099\u0097\3\2\2\2\u009a\u009c\5\24\13\2\u009b\u009a\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\23\3\2\2"+
		"\2\u009f\u009d\3\2\2\2\u00a0\u00a5\7\20\2\2\u00a1\u00a6\7!\2\2\u00a2\u00a6"+
		"\7\13\2\2\u00a3\u00a6\7\5\2\2\u00a4\u00a6\5\26\f\2\u00a5\u00a1\3\2\2\2"+
		"\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a8\7\35\2\2\u00a8\u00a9\5\20\t\2\u00a9\25\3\2\2\2\u00aa"+
		"\u00ab\7!\2\2\u00ab\u00ac\7 \2\2\u00ac\u00ad\7!\2\2\u00ad\27\3\2\2\2\u00ae"+
		"\u00af\7\21\2\2\u00af\u00b0\7\35\2\2\u00b0\u00b1\5\20\t\2\u00b1\31\3\2"+
		"\2\2\u00b2\u00b5\5\34\17\2\u00b3\u00b4\t\2\2\2\u00b4\u00b6\5\34\17\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\33\3\2\2\2\u00b7\u00ba\5\36\20"+
		"\2\u00b8\u00b9\t\3\2\2\u00b9\u00bb\5\34\17\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\35\3\2\2\2\u00bc\u00cd\7\5\2\2\u00bd\u00cd\7\13\2"+
		"\2\u00be\u00cd\7!\2\2\u00bf\u00cd\7\"\2\2\u00c0\u00c1\7\"\2\2\u00c1\u00c3"+
		"\7\33\2\2\u00c2\u00c4\5 \21\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2"+
		"\u00c4\u00c5\3\2\2\2\u00c5\u00cd\7\34\2\2\u00c6\u00c7\7\31\2\2\u00c7\u00cd"+
		"\5\36\20\2\u00c8\u00c9\7\33\2\2\u00c9\u00ca\5\32\16\2\u00ca\u00cb\7\34"+
		"\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00bc\3\2\2\2\u00cc\u00bd\3\2\2\2\u00cc"+
		"\u00be\3\2\2\2\u00cc\u00bf\3\2\2\2\u00cc\u00c0\3\2\2\2\u00cc\u00c6\3\2"+
		"\2\2\u00cc\u00c8\3\2\2\2\u00cd\37\3\2\2\2\u00ce\u00d3\5\32\16\2\u00cf"+
		"\u00d0\7\37\2\2\u00d0\u00d2\5\32\16\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5"+
		"\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4!\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\26%+\63:ELT[hp}\u0092\u0097\u009d\u00a5\u00b5\u00ba\u00c3"+
		"\u00cc\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}