//////////////////////////////////////////////////////////////
//
// Specification of the Fun syntactic analyser.
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


grammar Fun;

// This specifies the Fun grammar, defining the syntax of Fun.

@header{
    package ast;
}

//////// Programs

program
	:	var_decl* proc_decl+ EOF  # prog
	;


//////// Declarations

proc_decl
	:	PROC ID
		  LPAR formal_decl_seq? RPAR COLON
		  var_decl* seq_com DOT   # proc

	|	FUNC type ID
		  LPAR formal_decl_seq? RPAR COLON
		  var_decl* seq_com
		  RETURN expr DOT         # func
	;

formal_decl_seq
	:	formal_decl (COMMA formal_decl)* # formalseq
	;

formal_decl
	:	type ID                # formal
	;

var_decl
	:	type ID ASSN expr         # var
	;

type
	:	BOOL                      # bool
	|	INT                       # int
	;


//////// Commands

com
	:	ID ASSN expr              # assn
	|	ID LPAR actual_seq? RPAR       # proccall
							 
	|	IF expr COLON c1=seq_com
		  ( DOT              
		  | ELSE COLON c2=seq_com DOT   
		  )                       # if

	|	WHILE expr COLON          
		  seq_com DOT             # while

	// EXTENSION: Extension A - Sturcture of repeat-until command

	|   REPEAT COLON
		  seq_com
		UNTIL expr DOT          # repeat

	// END OF EXTENSION

	// EXTENSION: Extension B - Sturcture of switch command

	|   SWITCH expr
	      case_seq
		  default_case DOT         # switch

	// END OF EXTENSION
	;

seq_com
	:	com*                      # seq
	;

// EXTENSION: Extension B - Substurcture of switch command

case_seq
    :   case_com*                  # caseseq
    ;

case_com
    :   CASE (NUM | TRUE | FALSE | range) COLON seq_com      # case
    ;

range
    :   NUM RANGE NUM            # rangeofint
    ;

default_case
    :   DEFAULT COLON seq_com    # defaultcase
    ;

// END OF EXTENSION




//////// Expressions

expr
	:	e1=sec_expr
		  ( op=(EQ | LT | GT) e2=sec_expr )?
	;

sec_expr
	:	e1=prim_expr
		  ( op=(PLUS | MINUS | TIMES | DIV) e2=sec_expr )?
	;

prim_expr
	:	FALSE                  # false        
	|	TRUE                   # true
	|	NUM                    # num
	|	ID                     # id
	|	ID LPAR actual_seq? RPAR    # funccall
	|	NOT prim_expr          # not
	|	LPAR expr RPAR         # parens
	;

actual_seq
	:  expr (COMMA expr)*  # actualseq
	;




//////// Lexicon

BOOL	:	'bool' ;
ELSE	:	'else' ;
FALSE	:	'false' ;
FUNC	:	'func' ;
IF      :	'if' ;
INT     :	'int' ;
PROC	:	'proc' ;
RETURN  :	'return' ;
TRUE	:	'true' ;
WHILE	:	'while' ;

// EXTENSION: Extension A - Lexicon of repeat-until command

REPEAT  :  'repeat' ;
UNTIL   :  'until' ;

// END OF EXTENSION

// EXTENSION: Extension B - Lexicon of switch command

SWITCH  :  'switch' ;
CASE    :  'case' ;
DEFAULT :  'default' ;

// END OF EXTENSION

EQ      :	'==' ;
LT      :	'<' ;
GT      :	'>' ;
PLUS	:	'+' ;
MINUS	:	'-' ;
TIMES	:	'*' ;
DIV     :	'/' ;
NOT     :	'not' ;

ASSN	:	'=' ;

LPAR	:	'(' ;
RPAR	:	')' ;
COLON	:	':' ;
DOT     :	'.' ;
COMMA	:	',' ;

// EXTENSION: Extension B - Lexicon of switch command

RANGE   :  '..' ;

// END OF EXTENSION

NUM	:	DIGIT+ ;

ID	:	LETTER (LETTER | DIGIT)* ;

SPACE	:	(' ' | '\t')+   -> skip ;
EOL     :	'\r'? '\n'          -> skip ;
COMMENT :	'#' ~('\r' | '\n')* '\r'? '\n'  -> skip ;

fragment LETTER : 'a'..'z' | 'A'..'Z' ;
fragment DIGIT  : '0'..'9' ;