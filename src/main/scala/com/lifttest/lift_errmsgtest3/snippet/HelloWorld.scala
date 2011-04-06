package com.lifttest.lift_errmsgtest3 {
package snippet {

import _root_.scala.xml.{NodeSeq, Text}
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import net.liftweb.http.{StatefulSnippet,S, SHtml, DispatchSnippet, RequestVar, SessionVar}
import net.liftweb.http.js.JsCmds.{RedirectTo,SetHtml,Noop}
import com.lifttest.lift_errmsgtest3.lib._
import Helpers._

class HelloWorld {
                                                   
  var name = ""
	  
  def updateResults() = {
	SetHtml("result", if (name != "" ) Text("Hello " + name) else Text("") )
  }
  
  def setName(n: String) {
	if (n == "" ) {
		S.error("Name cannot be blank!")
	} else {
		S.clearCurrentNotices
	}
	name = n
  }
  def howdy(in: NodeSeq): NodeSeq = {
   	SHtml.ajaxForm(
		Helpers.bind("b", in, 
			"name" -> SHtml.text(name, setName(_)),
			"submit" -> SHtml.ajaxSubmit("Go", updateResults)
		)
	)
  }

}

}
}
