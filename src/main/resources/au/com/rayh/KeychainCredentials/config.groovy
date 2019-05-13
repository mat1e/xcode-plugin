package au.com.rayh.KeychainCredentials

f = namespace(lib.FormTagLib)
st = namespace('jelly:stapler')

f.entry(title:_('Keychain path'), field:'keychainPath') {
	f.textbox(clazz: 'required', default:'${HOME}/Library/Keychains/login.keychain')
}
f.entry(title:_('Keychain password'), field:'password') {
	f.password(clazz: 'required')
}
f.entry(title:_('Add to keychain search path after build'), field:'inSearchPath') {
	f.checkbox(default: false)
}

st.include(page: 'id-and-description', class: descriptor.clazz)