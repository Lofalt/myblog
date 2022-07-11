const isPro = process.env.NODE_ENV === 'production'

export const baseURL = isPro? '/MyBlog' : '/api'