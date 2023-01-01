import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import java.io.*;
import java.util.*;

/**
 * @author Javier Paniza
 */
public class EJBCodeGenerator extends CodeGenerator {

    protected String getPackagesFile() {
        return "packages-ejb.properties";
    }

    protected void generate(MetaComponent component, String componentsPath, String file) throws Exception {
        String dirPackage = toDirPackage(getPackageName());
        String modelPath = "../" + getProject() + "/gen-src-xava/" + dirPackage;
        String modelXEjbPath = modelPath + "/xejb";
        File fModelPath = new File(modelPath);
        fModelPath.mkdirs();
        File fModelXEjbPath = new File(modelXEjbPath);
        fModelXEjbPath.mkdirs();
        if (component.getMetaEntity().isGenerateXDocLet()) {
            System.out.println(XavaResources.getString("generating_xdoclet_code", component.getName()));
            String[] argv = { componentsPath + "/" + file, modelXEjbPath + "/" + component.getName() + "Bean.java", getJavaPackage(), component.getName() };
            EJBeanPG.main(argv);
            String[] argvInterface = { componentsPath + "/" + file, modelPath + "/I" + component.getName() + ".java", getJavaPackage(), component.getName() };
            InterfacePG.main(argvInterface);
        }
        Iterator itAggregatesBean = component.getMetaAggregatesBeanGenerated().iterator();
        while (itAggregatesBean.hasNext()) {
            MetaAggregateBean aggregate = (MetaAggregateBean) itAggregatesBean.next();
            String aggregateName = aggregate.getName();
            String[] argv = { componentsPath + "/" + file, modelPath + "/" + aggregateName + ".java", getJavaPackage(), component.getName(), aggregateName };
            System.out.println(XavaResources.getString("generating_aggregate_javabean_code", aggregateName));
            BeanPG.main(argv);
        }
        Iterator itAggregatesEjb = component.getMetaAggregatesEjbXDocLet().iterator();
        while (itAggregatesEjb.hasNext()) {
            MetaAggregateEjb aggregate = (MetaAggregateEjb) itAggregatesEjb.next();
            String aggregateName = aggregate.getName();
            System.out.println(XavaResources.getString("generating_aggregate_xdoclet_code", aggregateName));
            String[] argv = { componentsPath + "/" + file, modelXEjbPath + "/" + aggregateName + "Bean.java", getJavaPackage(), component.getName(), aggregateName };
            EJBeanPG.main(argv);
            String[] argvInterface = { componentsPath + "/" + file, modelPath + "/I" + aggregateName + ".java", getJavaPackage(), component.getName(), aggregateName };
            InterfacePG.main(argvInterface);
        }
    }
}
