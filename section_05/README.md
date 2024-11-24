## XSD options explanation

1. **Added `<xsdOptions>` Section**:
   - Each `<xsdOption>` entry specifies the path to an XSD file using the `<xsd>` element.
2. **Updated Schema Path**:
   - Replace `my-schema.xsd` with the name of your XSD file.
   - Ensure your XSD file is placed in the `src/main/resources/schemas` directory.

## Steps to Verify

1. Place your XSD file(s) in the `src/main/resources/schemas` directory.
2. Clean and rebuild the project:

   ```bash
   ./mvnw clean generate-sources
   ```

3. The generated Java classes should appear in the directory:

   ```bash
   target/generated-sources/xjc
   ```
   
## Multiple XSD files

If you have multiple XSD files, add an `<xsdOption>` entry for each file:

```xml
<xsdOptions>
    <xsdOption>
        <xsd>${project.basedir}/src/main/resources/schemas/schema1.xsd</xsd>
    </xsdOption>
    <xsdOption>
        <xsd>${project.basedir}/src/main/resources/schemas/schema2.xsd</xsd>
    </xsdOption>
</xsdOptions>
```

## Namespace Customization

If you need to customize the package or other options for a specific XSD, add additional configuration inside the `<xsdOption>`:

```xml
<xsdOptions>
    <xsdOption>
        <xsd>#{project.basedir}/src/main/resources/schemas/schema1.xsd</xsd>
        <packagename>com.example.generated</packagename>
    </xsdOption>
</xsdOptions>
```

## Verify XSD file

```bash
xmllint --noout --schema my-schema.xsd
```
