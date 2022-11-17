void main() {
  String valid = "abc@gmail.com";
  String inValid = "abc@a.com";
  String unknown = "abcgmail.com";
  print('Valid $valid ${valid.isEmail}');
  print('Invalid $inValid ${inValid.isEmail}');
  print('Invalid $unknown ${unknown.isEmail}');
}

extension FieldExtensions on String {
  bool get isEmail {
    RegExp emailReg = RegExp(r'^[a-z0-9]{2,}@.*?[a-z0-9]{2,}.[a-z0-9]{2,}');
    return emailReg.hasMatch(this);
  }
}
