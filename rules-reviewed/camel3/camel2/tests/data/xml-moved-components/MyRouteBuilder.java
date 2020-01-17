import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    public void configure() {
        from("file:src/data?noop=true")
            .choice()
            .when(xpath("/person/city = 'London'"))
            .to("xslt:xslt/copy-all.xsl")
            .otherwise()
            .to("file:target/messages/others");
    }

}
