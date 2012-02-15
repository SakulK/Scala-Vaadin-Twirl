package pl.sakulk.example

import com.vaadin.Application
import vaadin.scala._


class VaadinTwirlApplication extends Application {
	def init(): Unit = {
		setMainWindow(new Window("Vaadin-Scala-Twirl"))
		getMainWindow.addComponent(new Label("This Vaadin app uses ScalaWrappers!"))
		getMainWindow.addComponent(new Button("Hello Mike", _ => showHelloWindow("Mike","red")))
		getMainWindow.addComponent(new Button("Hello Mark", _ => showHelloWindow("Mark","blue")))
		getMainWindow.addComponent(new Button("Hello Micky", _ => showHelloWindow("Micky","green")))
	}

	def showHelloWindow(name: String, color: String) {
		val layout = new CustomLayout
		val twirlContent = html.hello(name, color)
		layout.setTemplateContents(twirlContent.toString)
		val window = new Window(name)
		window.setContent(layout)
		getMainWindow.addWindow(window)
	}
}