/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/main/resources/templates/**/*.html'],
  theme: {
    extend: {},
  },
  plugins: [require('daisyui'),require('@tailwindcss/forms')],
  daisyui: {
    themes: ["halloween", "dark", ],
  },
}

