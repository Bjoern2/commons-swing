# Commons Swing #
Util classes and components for Java Swing.
## Features ##
  * Bindings
  * Validations
  * Components
  * FormPanel
  * and more...
## Showcases ##
  * [Main Showcase](http://demo.commons-swing.googlecode.com/git/launch.jnlp)

## Examples ##
### Binding ###
```java

private void initBindings() {
bindings = new Bindings<Customer>();
bindings.addBinding(new Binding(txtFirstname, "firstName"));
bindings.addBinding(new Binding(txtLastname, "lastName"));
bindings.addBinding(new Binding(txtAddress1, "address.address1"));
bindings.addBinding(new Binding(txtEMail, "eMailAddress"));
bindings.addBinding(new Binding(cmbGender, "gender"));
bindings.addBinding(new Binding(chkNewsletter, "newsletter"));
bindings.bind(Customer.createCustomer());
}
```
### Validating ###
```java

private void initValidators() {
validators = new Validators();
validators.add(txtFirstname, new NotEmptyValidator(), notFirstname, notForm);
validators.add(txtEMail, new EMailAddressValidator(), notEMail, notForm);
validators.add(cmbGender, new NotNullValidator(), notGender, notForm);

validators.addValidationListener(new ValidationListener() {
@Override
public void validate(boolean valid) {
btnSave.setEnabled(valid);
}
});
validators.revalidate();
}
```


[![](http://web-static-cloudfront.s3.amazonaws.com/images/badges/BuiltOnDEV.png)](https://commons-swing.ci.cloudbees.com/)